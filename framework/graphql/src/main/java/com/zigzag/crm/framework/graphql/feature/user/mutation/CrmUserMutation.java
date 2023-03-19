package com.zigzag.crm.framework.graphql.feature.user.mutation;

import com.zigzag.crm.framework.graphql.feature.user.dto.DtoGqlCrmUser;
import com.zigzag.crm.framework.graphql.feature.user.mapper.GqlMapperCrmUser;
import com.zigzag.crm.usecase.api.user.Usecase_CreateUser;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CrmUserMutation {

    private final Usecase_CreateUser usecaseCreateUser;
    private final GqlMapperCrmUser gqlMapperCrmUser;

    @MutationMapping
    public Mono<DtoGqlCrmUser> newUser( @Argument DtoGqlCrmUser user)  {
        var newUserDto = gqlMapperCrmUser.convertToCreateRequestDto(user);
        var savedUserMono = usecaseCreateUser.execute(newUserDto);
        return savedUserMono.map(u -> gqlMapperCrmUser.convertToResponseDto(u));
    }
}
