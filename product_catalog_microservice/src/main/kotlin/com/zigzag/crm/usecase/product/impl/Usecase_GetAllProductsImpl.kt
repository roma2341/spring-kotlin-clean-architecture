package com.zigzag.crm.usecase.product.impl

import com.zigzag.crm.framework.domain.api.features.lead.IProductRepository
import com.zigzag.crm.usecase.lead.dto.ProductDto
import com.zigzag.crm.usecase.product.api.Usecase_FindProducts
import com.zigzag.crm.usecase.product.api.Usecase_GetAllProducts
import com.zigzag.crm.usecase.product.mapper.ProductMapper
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class Usecase_GetAllProductsImpl(private val productRepository: IProductRepository,
                                 private val productMapper: ProductMapper
) : Usecase_GetAllProducts {
    override fun execute(): Flux<ProductDto.Response.Public> {
        val searchResults = productRepository.findAll();
        return searchResults.map { productMapper.convertEntityToDto(it) }
    }
}