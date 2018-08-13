package com.neu.edu.GraphQLResolvers;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.neu.edu.domain.Link;
import com.neu.edu.repository.LinkRepository;

/**
 * Created by deepakkhobragade on 12/08/18.
 */
public class Mutation implements GraphQLRootResolver {

    private final LinkRepository linkRepository;

    public Mutation(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public Link createLink(String url, String description) {
        System.out.println("Adding link " + url + "and description " + description + "...");
        Link link = new Link(url, description);
        linkRepository.saveLink(link);
        return link;
    }

}
