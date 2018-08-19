package com.neu.edu.repository;

import com.mongodb.client.MongoCollection;
import com.neu.edu.domain.Link;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.all;
import static com.mongodb.client.model.Filters.eq;

/**
 * Created by deepakkhobragade on 12/08/18.
 */
public class LinkRepository {

    private final MongoCollection<Document> links;

    public LinkRepository(MongoCollection<Document> links){
        this.links = links;
    }

    public Link findById(String id){
        Document document = links.find(eq("_id", new ObjectId(id))).first();
        return link(document);
    }

    private Link link(Document document){
        return new Link(
                document.get("_id").toString(),
                document.getString("url"),
                document.getString("description"),
                document.getString("postedBy")
        );
    }

    public List<Link> getAllLinks() {
        List<Link> allLinks = new ArrayList<>();
        for (Document doc : links.find()) {
            Link link = new Link(
                    doc.get("_id").toString(),
                    doc.getString("url"),
                    doc.getString("description"),
                    doc.getString("postedBy")
            );
            allLinks.add(link);
        }
        return allLinks;
    }

    public void saveLink(Link link) {
        System.out.println("Saving the Link " + link.getUrl());
        Document doc = new Document();
        doc.append("url", link.getUrl());
        doc.append("description", link.getDescription());
        doc.append("postedBy", link.getUserId());
        links.insertOne(doc);
    }

}
