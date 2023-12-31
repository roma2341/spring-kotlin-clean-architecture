package com.zigzag.crm.usecase.lead

import com.zigzag.crm.framework.domain.api.features.lead.ILeadRepository
import com.zigzag.crm.framework.domain.api.features.lead.Lead
import com.zigzag.crm.usecase.lead.dto.AssignLeadToAgentRequest
import com.zigzag.crm.usecase.lead.impl.Usecase_AssignLeadToAgent_Impl
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import reactor.core.publisher.Mono


@ExtendWith(MockitoExtension::class)
class Usecase_AssignLeadToAgent_ImplTest {

    @InjectMocks
    private lateinit var usecaseAssignLeadToAgent: Usecase_AssignLeadToAgent_Impl;

//    @Mock
//    private lateinit var userRepository: ICrmUserRepository

    @Mock
    private lateinit var leadRepository: ILeadRepository;

    @Test
    fun `should assign lead to agent`() {
        // given
        val agentId = "AGENT_ID";
        val leadId = "LEAD_ID";
        val lead = Lead(id=leadId);
        val request = AssignLeadToAgentRequest(leadId,agentId);
       // Mockito.`when`(userRepository.findById(agentId)).thenReturn(Mono.just(agent))
        Mockito.`when`(leadRepository.findById(leadId)).thenReturn(Mono.just(lead));

        val expectedLead = Lead(id=leadId,agentId = agentId);
        // when
        val result = usecaseAssignLeadToAgent.execute(request).block();
        // then
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(expectedLead));
    }
}
