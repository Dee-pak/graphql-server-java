package com.neu.edu.repository;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class TeamRepositoy {

    private final MongoCollection<Document> teams;

    public TeamRepositoy(MongoCollection<Document> teams) {
        this.teams = teams;
    }


}
