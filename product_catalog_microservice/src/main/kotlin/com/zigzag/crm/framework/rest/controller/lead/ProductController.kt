package com.zigzag.crm.framework.rest.lead

import com.zigzag.crm.usecase.lead.dto.ProductDto
import com.zigzag.crm.usecase.product.api.Usecase_FindProductById
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/product/v1")
class ProductController(
    private val usecaseFindProductById: Usecase_FindProductById,
) {
    @GetMapping("/{leadId}")
    fun getUser(@PathVariable leadId: String): Mono<ProductDto.Response.Public> {
        return usecaseFindProductById.execute(leadId);
    }
}