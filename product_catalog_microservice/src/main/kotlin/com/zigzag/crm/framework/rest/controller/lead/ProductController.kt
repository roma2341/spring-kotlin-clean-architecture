package com.zigzag.crm.framework.rest.lead

import com.zigzag.crm.usecase.lead.dto.ProductDto
import com.zigzag.crm.usecase.product.api.Usecase_CreateProduct
import com.zigzag.crm.usecase.product.api.Usecase_FindProductById
import com.zigzag.crm.usecase.product.api.Usecase_FindProducts
import com.zigzag.crm.usecase.product.api.Usecase_GetAllProducts
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/products/v1")
class ProductController(
    private val usecaseFindProductById: Usecase_FindProductById,
    private val usecaseFindproducts: Usecase_FindProducts,
    private val usecase_GetAllProducts: Usecase_GetAllProducts,
    private val usecaseCreateproduct: Usecase_CreateProduct
) {

    @PostMapping
    fun createProduct(@RequestBody product: ProductDto.Request.Create): Mono<ProductDto.Response.Public> {
        return usecaseCreateproduct.execute(product)
    }

    @GetMapping("/{leadId}")
    fun getProduct(@PathVariable leadId: String): Mono<ProductDto.Response.Public> {
        return usecaseFindProductById.execute(leadId);
    }
    @GetMapping("/search")
    fun searchProducts(@RequestParam searchTerm: String): Flux<ProductDto.Response.Public> {
        return usecaseFindproducts.execute(searchTerm);
    }
    @GetMapping
    fun getProducts(): Flux<ProductDto.Response.Public> {
        return usecase_GetAllProducts.execute();
    }
}