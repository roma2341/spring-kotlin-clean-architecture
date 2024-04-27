package com.zigzag.crm.usecase.feature.user.mapper

import com.zigzag.crm.framework.domain.api.features.user.CrmUser
import com.zigzag.crm.usecase.feature.user.dto.CrmUserDto

abstract class CrmUserMapper {
   companion object {
        fun convertDtoToEntity(userDto: CrmUserDto.Request.Create): CrmUser {
           return CrmUser( // replace with correct default or error handling
               firstName = userDto.firstName,
               lastName = userDto.lastName,
               email = userDto.email
               // add others parameters here
           )
       }

        fun convertEntityToDto(user: CrmUser): CrmUserDto.Response.Public {
           return CrmUserDto.Response.Public(
               id = user.id,
               firstName = user.firstName,
               lastName = user.lastName,
               email = user.email
               // add others parameters here
           )
       }
   }
}