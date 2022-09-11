package com.zigzag.crm.usecase.api.feature.user

import com.zigzag.crm.usecase.api.IUsecase
import com.zigzag.crm.usecase.api.dto.user.CrmUserDto
import org.springframework.stereotype.Component

@Component
interface IUsecaseCreateUser: IUsecase<CrmUserDto.Response.Public, CrmUserDto.Request.Create> {
}
