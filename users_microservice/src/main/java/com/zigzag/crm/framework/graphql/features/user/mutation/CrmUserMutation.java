package com.zigzag.crm.framework.graphql.features.user.mutation;

import com.zigzag.crm.usecase.feature.user.api.Usecase_CreateUser;
import com.zigzag.crm.usecase.feature.user.dto.CrmUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class CrmUserMutation {

    @Autowired
    private Usecase_CreateUser usecaseCreateUser;

    @MutationMapping
    public Mono<CrmUserDto.Response.Public> createUser( @Argument CrmUserDto.Request.Create user)  {
        return usecaseCreateUser.execute(user);
    }
}