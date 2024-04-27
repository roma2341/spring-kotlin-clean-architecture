package com.zigzag.crm.usecase.lead
import com.zigzag.crm.framework.domain.api.features.lead.Lead
import com.zigzag.crm.usecase.lead.api.Usecase_AssignLeadToAgent
import com.zigzag.crm.usecase.lead.dto.AssignLeadToAgentRequest
import com.zigzag.crm.usecase.lead.impl.Usecase_AssignSuitableAgentForLead_Impl

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import reactor.core.publisher.Mono

@ExtendWith(MockitoExtension::class)
class Usecase_AssignSuitableAgentForLead_ImplTest {
    @InjectMocks
    private lateinit var usecaseAssignSuitableAgentForLead: Usecase_AssignSuitableAgentForLead_Impl
    @Mock
    private lateinit var usecase_AssignLeadToAgent: Usecase_AssignLeadToAgent
    @Test
    fun `should find agent for lead`() {
        //given
        val agentId = "AGENT_ID"
        val leadId = "LEAD_ID"
        val lead = Lead(id = leadId)
        val expectedLead = Lead(id = leadId, agentId = agentId)
        val request = AssignLeadToAgentRequest(
            leadId=leadId,
            agentId=agentId
        )
        Mockito.`when`(usecase_AssignLeadToAgent.execute(request)).thenReturn(Mono.just(expectedLead))
        //when
        val result = usecaseAssignSuitableAgentForLead.execute(leadId).block()
        //then
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(expectedLead))
    }
}

