package com.zigzag.crm.framework.graphql.feature.lead.query;

import com.zigzag.crm.usecase.feature.lead.api.Usecase_FindLeadById;
import com.zigzag.crm.usecase.feature.lead.api.Usecase_FindLeads;
import com.zigzag.crm.usecase.feature.lead.dto.LeadDto;
import com.zigzag.crm.usecase.feature.lead.mapper.LeadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class LeadQuery {

    @Autowired
    private  Usecase_FindLeads usecaseFindLeads;
    @Autowired
    private  Usecase_FindLeadById usecaseFindLeadById;
    @Autowired
    private  LeadMapper leadMapper;
    @QueryMapping
    Flux<LeadDto.Response.Public> leads(@Argument LeadDto.Request.Search filter)  {
        return usecaseFindLeads.execute(filter);
    }
    @QueryMapping
    Mono<LeadDto.Response.Public> lead(@Argument String id)  {
        return usecaseFindLeadById.execute(id);
    }
}
