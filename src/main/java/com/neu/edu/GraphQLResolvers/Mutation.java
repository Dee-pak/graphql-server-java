package com.neu.edu.GraphQLResolvers;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.neu.edu.authentication.AuthContext;
import com.neu.edu.authentication.AuthData;
import com.neu.edu.domain.Link;
import com.neu.edu.domain.SignInPayload;
import com.neu.edu.domain.User;
import com.neu.edu.repository.LinkRepository;
import com.neu.edu.repository.UserRepository;
import graphql.GraphQLException;
import graphql.schema.DataFetchingEnvironment;

import java.util.IllegalFormatException;

/**
 * Created by deepakkhobragade on 12/08/18.
 */
public class Mutation implements GraphQLRootResolver {

    private final LinkRepository linkRepository;
    private final UserRepository userRepository;

    public Mutation(LinkRepository linkRepository, UserRepository userRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
    }

    public Link createLink(String url, String description, DataFetchingEnvironment env) {
        AuthContext context = env.getContext();
        Link link = new Link(url, description, context.getUser().getId());
        linkRepository.saveLink(link);
        return link;
    }

    public User createUser(String name, AuthData authData){
        User user = new User(name, authData.getEmail(), authData.getPassword());
        return userRepository.saveUser(user);
    }

    public SignInPayload signInUser(AuthData authData) throws IllegalAccessException {
        User user = userRepository.findByEmail(authData.getEmail());
        if(user.getPassword().equals(authData.getPassword())){
            return new SignInPayload(user.getId(), user);
        }
        throw new GraphQLException("Invalid Credentials!");
    }

}
