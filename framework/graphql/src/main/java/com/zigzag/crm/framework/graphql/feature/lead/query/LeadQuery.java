package com.zigzag.crm.framework.graphql.feature.lead.query;

import com.zigzag.crm.usecase.feature.lead.api.Usecase_FindLeads;
import com.zigzag.crm.usecase.feature.lead.dto.LeadDto;
import com.zigzag.crm.usecase.feature.lead.mapper.LeadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
@RequiredArgsConstructor
public class LeadQuery {

    private final Usecase_FindLeads usecaseFindLeads;
    private final LeadMapper leadMapper;
    @QueryMapping
    Flux<LeadDto.Response.Public> findLeads(@Argument LeadDto.Request.Search filter)  {
        return usecaseFindLeads.execute(filter);
    }
}
