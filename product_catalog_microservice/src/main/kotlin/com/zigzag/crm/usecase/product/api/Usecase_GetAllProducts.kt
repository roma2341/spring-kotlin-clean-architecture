package com.zigzag.crm.usecase.product.api

import Usecase
import com.zigzag.crm.usecase.lead.dto.ProductDto
import org.zigzag.crm.common.usecase.CrmUsecase
import org.zigzag.crm.common.usecase.CrmUsecaseNoArg
import reactor.core.publisher.Flux

@Usecase
interface Usecase_GetAllProducts:
    CrmUsecaseNoArg<Flux<ProductDto.Response.Public>> {

}
