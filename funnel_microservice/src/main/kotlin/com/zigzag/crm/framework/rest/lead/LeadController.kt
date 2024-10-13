package com.zigzag.crm.framework.rest.lead

import com.zigzag.crm.framework.rest.user.dto.CrmUserDto
import com.zigzag.crm.usecase.lead.api.Usecase_AcceptLead
import com.zigzag.crm.usecase.lead.api.Usecase_FindLeadById
import com.zigzag.crm.usecase.lead.api.Usecase_FindAllLeads
import com.zigzag.crm.usecase.lead.api.Usecase_FindSuitableAgentForLead
import com.zigzag.crm.usecase.lead.dto.AcceptLeadArgs
import com.zigzag.crm.usecase.lead.dto.LeadDto
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/leads")
class LeadController(
    private val usecaseFindLeadById: Usecase_FindLeadById,
    private val usecaseFindSuitableAgentForLead: Usecase_FindSuitableAgentForLead,
    private val usecaseFindLeads: Usecase_FindAllLeads,
    private val usecaseAcceptFreeLead: Usecase_AcceptLead
) {
    @GetMapping("/{leadId}")
    fun getLead(@PathVariable leadId: String): Mono<LeadDto.Response.Public> {
        return usecaseFindLeadById.execute(leadId);
    }
    @GetMapping("/agent/search")
    fun searchAgent(): Mono<CrmUserDto.Response.Public> {
        return usecaseFindSuitableAgentForLead.execute("test");
    }
    @GetMapping()
    fun getLeads(pageable: Pageable): Flux<LeadDto.Response.Public> {
        return usecaseFindLeads.execute(pageable);
    }
    @PostMapping("/accept")
    fun acceptFreeLead(@RequestParam("leadId") leadId: String,
                       @RequestParam("agentId") agentId: String): Mono<Nothing> {
        return usecaseAcceptFreeLead.execute(AcceptLeadArgs(leadId,agentId));
    }
}