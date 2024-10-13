package com.zigzag.crm.framework.rest.lead

import com.zigzag.crm.usecase.lead.api.Usecase_AssignSuitableAgentForLead
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/admin/leads")
class LeadAdminController(private val usecaseAssignSuitableAgentForLead: Usecase_AssignSuitableAgentForLead) {
    @PostMapping("/assignment/agent")
    fun acceptFreeLead(@RequestParam leadId: String){
        usecaseAssignSuitableAgentForLead.execute(leadId);
    }
}
