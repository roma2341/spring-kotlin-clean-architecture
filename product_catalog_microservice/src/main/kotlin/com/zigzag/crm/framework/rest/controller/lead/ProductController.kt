package com.zigzag.crm.framework.rest.lead

import com.zigzag.crm.usecase.lead.dto.ProductDto
import com.zigzag.crm.usecase.product.api.Usecase_FindProductById
import com.zigzag.crm.usecase.product.api.Usecase_FindProducts
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/product/v1")
class ProductController(
    private val usecaseFindProductById: Usecase_FindProductById,
    private val usecaseFindproducts: Usecase_FindProducts
) {
    @GetMapping("/{leadId}")
    fun getProduct(@PathVariable leadId: String): Mono<ProductDto.Response.Public> {
        return usecaseFindProductById.execute(leadId);
    }
    @GetMapping
    fun getProducts(@RequestParam searchTerm: String): Flux<ProductDto.Response.Public> {
        return usecaseFindproducts.execute(searchTerm);
    }
}