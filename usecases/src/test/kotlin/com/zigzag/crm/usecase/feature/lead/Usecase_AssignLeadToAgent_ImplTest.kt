package com.zigzag.crm.usecase.feature.lead

import com.zigzag.crm.framework.domain.api.features.lead.ILeadRepository
import com.zigzag.crm.framework.domain.api.features.lead.Lead
import com.zigzag.crm.framework.domain.api.features.user.CrmUser
import com.zigzag.crm.framework.domain.api.features.user.ICrmUserRepository
import com.zigzag.crm.usecase.feature.lead.dto.AssignLeadToAgentRequest
import com.zigzag.crm.usecase.feature.user.mapper.CrmUserMapper
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
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

    @Mock
    private lateinit var userRepository: ICrmUserRepository

    @Mock
    private lateinit var leadRepository: ILeadRepository;

    @Mock
    private lateinit var crmUserMapper: CrmUserMapper

    @BeforeEach
    fun setUp() {
        //usecaseAssignLeadToAgent = Usecase_AssignLeadToAgent_Impl(userRepository,leadRepository)
    }
    @Test
    fun `should assign lead to agent`() {
        // given
       /* val userDto = CrmUserDto.Request.Create(firstName = "John",lastName = "Smith", email = "john@example.com")
        val userEntity = CrmUser(firstName = "John",lastName = "Smith", email = "john@example.com")
        val persistedEntity = Mono.just(userEntity)
        Mockito.`when`(crmUserMapper.convertDtoToEntity(userDto)).thenReturn(userEntity)
        Mockito.`when`(userRepository.createUser(userEntity)).thenReturn(persistedEntity)
        val expectedResponse = CrmUserDto.Response.Public(firstName = "John",lastName = "Smith", email = "john@example.com")
        Mockito.`when`(crmUserMapper.convertEntityToDto(userEntity)).thenReturn(expectedResponse)*/
        val agentId = "AGENT_ID";
        val leadId = "LEAD_ID";
        val agent = CrmUser(id=agentId);
        val lead = Lead(id=leadId);
        val request = AssignLeadToAgentRequest(leadId,agentId);
        Mockito.`when`(userRepository.findById(agentId)).thenReturn(Mono.just(agent))
        Mockito.`when`(leadRepository.findById(leadId)).thenReturn(Mono.just(lead));

        val expectedLead = Lead(id=leadId,agentId = agentId);
        // when
        val result = usecaseAssignLeadToAgent.execute(request).block();
        // then
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(expectedLead));
    }
}
