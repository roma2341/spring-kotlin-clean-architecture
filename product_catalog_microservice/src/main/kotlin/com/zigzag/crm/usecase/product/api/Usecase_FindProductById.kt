package com.zigzag.crm.usecase.product.api

import Usecase
import com.zigzag.crm.usecase.lead.dto.ProductDto
import org.zigzag.crm.common.usecase.CrmUsecase
import reactor.core.publisher.Mono

@Usecase
interface Usecase_FindProductById: CrmUsecase<Mono<ProductDto.Response.Public>, String> {
}
