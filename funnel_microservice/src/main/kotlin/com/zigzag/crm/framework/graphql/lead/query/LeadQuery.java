package com.zigzag.crm.framework.graphql.lead.query;

import com.zigzag.crm.usecase.lead.api.Usecase_FindLeadById;
import com.zigzag.crm.usecase.lead.api.Usecase_FindAllLeads;
import com.zigzag.crm.usecase.lead.dto.LeadDto;
import com.zigzag.crm.usecase.lead.mapper.LeadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class LeadQuery {

    @Autowired
    private Usecase_FindAllLeads usecaseFindLeads;
    @Autowired
    private Usecase_FindLeadById usecaseFindLeadById;
    @Autowired
    private LeadMapper leadMapper;
    @QueryMapping
    Flux<LeadDto.Response.Public> leads(@Argument LeadDto.Request.Search filter)  {
        return usecaseFindLeads.execute(filter);
    }
    @QueryMapping
    Mono<LeadDto.Response.Public> lead(@Argument String id)  {
        return usecaseFindLeadById.execute(id);
    }
}
