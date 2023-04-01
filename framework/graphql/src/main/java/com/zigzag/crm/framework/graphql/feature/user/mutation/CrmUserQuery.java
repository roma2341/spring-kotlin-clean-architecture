package com.zigzag.crm.framework.graphql.feature.user.mutation;

import com.zigzag.crm.usecase.feature.user.api.Usecase_FindAllUsers;
import com.zigzag.crm.usecase.feature.user.dto.CrmUserDto;
import com.zigzag.crm.usecase.feature.user.mapper.CrmUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
@RequiredArgsConstructor
public class CrmUserQuery {
    private final Usecase_FindAllUsers usecaseFindAllUsers;
    private final CrmUserMapper crmUserMapper;

    @QueryMapping
    Flux<CrmUserDto.Response.Public> findAllUsers()  {
        return usecaseFindAllUsers.execute();
    }
}
