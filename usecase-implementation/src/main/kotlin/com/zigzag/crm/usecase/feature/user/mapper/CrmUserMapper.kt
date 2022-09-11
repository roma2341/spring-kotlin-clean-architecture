package com.zigzag.crm.usecase.feature.user.mapper

import com.zigzag.crm.framework.domain.api.features.user.CrmUser
import com.zigzag.crm.usecase.api.dto.user.CrmUserDto
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface CrmUserMapper {
    fun convertRequestCreateToDomainModel(userDto: CrmUserDto.Request.Create): CrmUser
    fun convertDomainModeltoResponsePublicDto(user: CrmUser): CrmUserDto.Response.Public
}
