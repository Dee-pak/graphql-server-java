package com.neu.edu.domain;

/**
 * Created by deepakkhobragade on 12/08/18.
 */
public class Link {

    private final String url;
    private final String description;

    public Link(String url, String description){
        this.url = url;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }
}
