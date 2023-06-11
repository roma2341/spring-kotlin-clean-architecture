package com.zigzag.crm.framework.graphql.feature.user.query;

import com.zigzag.crm.usecase.feature.user.api.Usecase_FindAllUsers;
import com.zigzag.crm.usecase.feature.user.dto.CrmUserDto;
import com.zigzag.crm.usecase.feature.user.mapper.CrmUserMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
@RequiredArgsConstructor
public class CrmUserQuery {
    private final Usecase_FindAllUsers usecaseFindAllUsers;
    private final CrmUserMapper crmUserMapper;
    @PostConstruct
    public void graphiqlInited(){
        System.out.println("Graphiql inited");
    }

    @QueryMapping
    Flux<CrmUserDto.Response.Public> findAllUsers()  {
        return usecaseFindAllUsers.execute();
    }
}
