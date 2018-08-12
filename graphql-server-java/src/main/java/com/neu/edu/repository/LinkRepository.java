package com.neu.edu.repository;

import com.neu.edu.domain.Link;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepakkhobragade on 12/08/18.
 */
public class LinkRepository {

    private final List<Link> links;

    // TODO: Get these links from database or a webservice.
    public LinkRepository(){
        links = new ArrayList<Link>();
        links.add(new Link("https://dee-pak.github.io/portfolio/", "Deepak Khobragade - Portfolio"));
        links.add(new Link("https://www.linkedin.com/in/dee-pak/", "Deepak Khobragade - LinkedIn"));
        links.add(new Link("https://github.com/Dee-pak", "Deepak Khobragade - Github"));
    }

    public List<Link> getAllLinks(){
        return links;
    }

    public void saveLink(Link link){
        links.add(link);
    }
}
