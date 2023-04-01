package com.zigzag.crm.usecase.feature.user.mapper

import com.zigzag.crm.framework.domain.api.features.user.CrmUser
import com.zigzag.crm.usecase.feature.user.dto.CrmUserDto
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface CrmUserMapper {
    fun convertDtoToEntity(userDto: CrmUserDto.Request.Create): CrmUser
    fun convertEntityToDto(user: CrmUser): CrmUserDto.Response.Public
}
