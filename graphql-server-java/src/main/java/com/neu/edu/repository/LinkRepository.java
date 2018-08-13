package com.neu.edu.repository;

import com.mongodb.client.MongoCollection;
import com.neu.edu.domain.Link;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.print.Doc;
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
                document.getString("description")
        );
    }

    public List<Link> getAllLinks(){
        List<Link> allLinks = new ArrayList<Link>();
        for (Document document : links.find()){
            allLinks.add(link(document));
        }
        return allLinks;
    }

    public void saveLink(Link link){
        Document document = new Document();
        document.append("url", link.getUrl());
        document.append("description", link.getDescription());
        links.insertOne(document);
    }

}
