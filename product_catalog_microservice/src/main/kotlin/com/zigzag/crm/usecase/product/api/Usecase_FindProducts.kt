package com.zigzag.crm.usecase.product.api

import Usecase
import com.zigzag.crm.usecase.lead.dto.ProductDto
import org.zigzag.crm.common.usecase.CrmUsecase
import reactor.core.publisher.Flux

@Usecase
interface Usecase_FindProducts:
    CrmUsecase<Flux<ProductDto.Response.Public>, String> {

}
