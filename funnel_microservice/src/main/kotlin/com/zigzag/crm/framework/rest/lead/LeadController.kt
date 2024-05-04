package com.zigzag.crm.framework.rest.lead

import com.zigzag.crm.framework.domain.api.features.lead.Lead
import com.zigzag.crm.framework.rest.user.dto.CrmUserDto
import com.zigzag.crm.usecase.lead.api.Usecase_FindLeadById
import com.zigzag.crm.usecase.lead.api.Usecase_FindLeads
import com.zigzag.crm.usecase.lead.api.Usecase_FindSuitableAgentForLead
import com.zigzag.crm.usecase.lead.dto.LeadDto
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/lead/v1")
class LeadController(
    private val usecaseFindLeadById: Usecase_FindLeadById,
    private val usecaseFindSuitableAgentForLead: Usecase_FindSuitableAgentForLead
) {
    @GetMapping("/{leadId}")
    fun getUser(@PathVariable leadId: String): Mono<LeadDto.Response.Public> {
        return usecaseFindLeadById.execute(leadId);
    }
    @GetMapping("/agent/search")
    fun searchAgent(): Mono<CrmUserDto.Response.Public> {
        return usecaseFindSuitableAgentForLead.execute("test");
    }
}