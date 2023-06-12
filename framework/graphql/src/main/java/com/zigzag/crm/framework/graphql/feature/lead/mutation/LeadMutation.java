package com.zigzag.crm.framework.graphql.feature.lead.mutation;

import com.zigzag.crm.usecase.feature.lead.api.Usecase_CreateLead;
import com.zigzag.crm.usecase.feature.lead.dto.LeadDto;
import com.zigzag.crm.usecase.feature.user.api.Usecase_CreateUser;
import com.zigzag.crm.usecase.feature.user.dto.CrmUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class LeadMutation {
    private final Usecase_CreateLead usecaseCreateLead;

    @MutationMapping
    public Mono<LeadDto.Response.Public> createLead(@Argument LeadDto.Request.Create lead)  {
        return usecaseCreateLead.execute(lead);
    }
}
