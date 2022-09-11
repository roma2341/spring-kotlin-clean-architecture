package com.zigzag.crm.usecase.api.feature.user

import com.zigzag.crm.usecase.api.IUsecase
import com.zigzag.crm.usecase.api.dto.user.CrmUserDto

interface IUsecase_FindUserById: IUsecase<CrmUserDto.Response.Public, Long> {
}
