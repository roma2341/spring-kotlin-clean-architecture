package com.zigzag.crm.usecase.user.converter

import com.zigzag.crm.framework.domain.features.user.CrmUser
import com.zigzag.crm.usecase.user.dto.CrmUserDto
import org.mapstruct.Mapper

@Mapper
interface CrmUserMapper {
    fun toUser(userDto: CrmUserDto): CrmUser
    fun toUserDto(user: CrmUser): CrmUserDto
}
