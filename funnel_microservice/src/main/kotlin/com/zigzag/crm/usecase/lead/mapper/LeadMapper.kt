package com.zigzag.crm.usecase.lead.mapper

import com.zigzag.crm.framework.domain.api.features.lead.Lead
import com.zigzag.crm.usecase.lead.dto.LeadDto

abstract class LeadMapper {
   companion object {
       fun convertDtoToEntity(leadDto: LeadDto.Request.Create): Lead {
           return Lead(
               firstName = leadDto.firstName,
               lastName = leadDto.lastName,
               email = leadDto.email
           )
       }
       fun convertDtoToEntity(leadDto: LeadDto.Request.Search): Lead {
           return Lead(
               firstName = leadDto.firstName,
               lastName = leadDto.lastName,
           )
       }
       fun convertEntityToDto(lead: Lead): LeadDto.Response.Public {
           return LeadDto.Response.Public(
               firstName = lead.firstName,
               lastName = lead.lastName,
               email = lead.email,
               leadFunnelStatus = lead.leadFunnelStatus,
               id = lead.id
           )
       }
   }
}

