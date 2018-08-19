package com.neu.edu;

import com.coxautodev.graphql.tools.SchemaParser;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.neu.edu.GraphQLResolvers.LinkResolver;
import com.neu.edu.GraphQLResolvers.Mutation;
import com.neu.edu.GraphQLResolvers.Query;
import com.neu.edu.GraphQLResolvers.SignInResolver;
import com.neu.edu.authentication.AuthContext;
import com.neu.edu.domain.User;
import com.neu.edu.repository.LinkRepository;
import com.neu.edu.repository.UserRepository;
import graphql.schema.GraphQLSchema;
import graphql.servlet.GraphQLContext;
import graphql.servlet.SimpleGraphQLServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

	private static final LinkRepository linkRepository;
	private static final UserRepository userRepository;

	static {
		MongoDatabase mongoDatabase = new MongoClient().getDatabase("links-data");
		linkRepository = new LinkRepository(mongoDatabase.getCollection("links"));
		userRepository = new UserRepository(mongoDatabase.getCollection("users"));

	}

	public GraphQLEndpoint(){
		super(buildSchema());
	}

	private static GraphQLSchema buildSchema() {
		return SchemaParser.newParser()
				.file("schema.graphqls")
				.resolvers(
						new Query(linkRepository),
						new Mutation(linkRepository, userRepository),
						new SignInResolver(),
						new LinkResolver(userRepository)
				)
				.build()
				.makeExecutableSchema();
	}

	@Override
	protected GraphQLContext createContext(Optional<HttpServletRequest> request, Optional<HttpServletResponse> response) {
		User user = request
				.map(req -> req.getHeader("Authorization"))
				.filter(id -> !id.isEmpty())
				.map(id -> id.replace("Bearer ", ""))
				.map(userRepository::findById)
				.orElse(null);
		return new AuthContext(user, request, response);
	}


}