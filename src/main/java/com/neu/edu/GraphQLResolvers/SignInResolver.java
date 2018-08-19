package com.neu.edu.GraphQLResolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.neu.edu.domain.SignInPayload;
import com.neu.edu.domain.User;

public class SignInResolver implements GraphQLResolver<SignInPayload> {

    public User user(SignInPayload payload) {
        return payload.getUser();
    }
}
