package com.zigzag.crm.usecase.product.api

import Usecase
import com.zigzag.crm.usecase.lead.dto.ProductDto
import org.springframework.stereotype.Component
import org.zigzag.crm.common.usecase.CrmUsecase
import reactor.core.publisher.Mono

@Component
@Usecase
interface Usecase_CreateProduct :
    CrmUsecase<Mono<ProductDto.Response.Public>, ProductDto.Request.Create> {
}
