public class GraphQLEndpoint extends SimpleGraphQLServlet {


	public GraphQLEndpoint() {
		super(SchemaParser.newParser()
			.file("schema.graphqls")
			.build()
			.makeExecutableSchema());
	}
}