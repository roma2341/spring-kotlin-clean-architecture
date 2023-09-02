package com.zigzag.crm.framework.graphql.lead.mutation;

import com.zigzag.crm.usecase.lead.api.Usecase_CreateLead;
import com.zigzag.crm.usecase.lead.dto.LeadDto;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class LeadMutation {
    @NotNull
    private Usecase_CreateLead usecaseCreateLead;

    @MutationMapping
    public Mono<LeadDto.Response.Public> createLead(@Argument LeadDto.Request.Create lead)  {
        return usecaseCreateLead.execute(lead);
    }
}
