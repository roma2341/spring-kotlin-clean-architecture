package com.zigzag.crm.usecase.lead.impl

import com.zigzag.crm.framework.domain.api.features.lead.IProductRepository
import com.zigzag.crm.usecase.lead.dto.ProductDto
import com.zigzag.crm.usecase.product.api.Usecase_FindProducts
import com.zigzag.crm.usecase.product.mapper.ProductMapper
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class Usecase_FindProducts_Impl(private val productRepository: IProductRepository,
    private val productMapper: ProductMapper
) : Usecase_FindProducts {
    override fun execute(searchValue: String): Flux<ProductDto.Response.Public> {
        val searchResults = productRepository.find(searchValue);
        return searchResults.map{productMapper.convertEntityToDto(it)}
    }
}
