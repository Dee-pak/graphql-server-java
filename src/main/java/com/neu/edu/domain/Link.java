package com.neu.edu.domain;

/**
 * Created by deepakkhobragade on 12/08/18.
 */
public class Link {

    private final String id;
    private final String url;
    private final String description;
    private final String userId;

    public Link(String url, String description, String userId){
        this(null, url, description, userId);
        System.out.println("In Link Constructor 1 !");
    }

    public Link(String id, String url, String description, String userId){
        System.out.println("In Link Constructor 2!");
        this.id = id;
        this.url = url;
        this.description = description;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public String getUserId() {
        return userId;
    }
}
