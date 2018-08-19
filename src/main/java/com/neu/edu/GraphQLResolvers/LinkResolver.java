package com.neu.edu.GraphQLResolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.neu.edu.domain.Link;
import com.neu.edu.domain.User;
import com.neu.edu.repository.UserRepository;

public class LinkResolver implements GraphQLResolver<Link> {

    private final UserRepository userRepository;

    public LinkResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User postedBy(Link link) {
        if (link.getUserId() == null) {
            return null;
        }
        return userRepository.findById(link.getUserId());
    }
}
