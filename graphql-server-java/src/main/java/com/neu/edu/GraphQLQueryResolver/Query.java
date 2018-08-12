package com.neu.edu.GraphQLQueryResolver;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.neu.edu.domain.Link;
import com.neu.edu.repository.LinkRepository;

import java.util.List;

/**
 * Created by deepakkhobragade on 12/08/18.
 */
public class Query implements GraphQLRootResolver {

    private final LinkRepository linkRepository;

    public Query(LinkRepository linkRepository){
        this.linkRepository = linkRepository;
    }

    public List<Link> getAllLinks(){
        return linkRepository.getAllLinks();
    }
}
