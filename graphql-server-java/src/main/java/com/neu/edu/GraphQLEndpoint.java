package com.neu.edu;

import com.coxautodev.graphql.tools.SchemaParser;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.neu.edu.GraphQLResolvers.Mutation;
import com.neu.edu.GraphQLResolvers.Query;
import com.neu.edu.repository.LinkRepository;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

	private static final LinkRepository linkRepository;

	static {
		MongoDatabase mongoDatabase = new MongoClient().getDatabase("links-data");
		linkRepository = new LinkRepository(mongoDatabase.getCollection("links"));
	}

	public GraphQLEndpoint(){
		super(buildSchema());
	}

	private static GraphQLSchema buildSchema() {
		return SchemaParser.newParser()
				.file("schema.graphqls")
				.resolvers(
						new Query(linkRepository),
						new Mutation(linkRepository)
				)
				.build()
				.makeExecutableSchema();
	}
}