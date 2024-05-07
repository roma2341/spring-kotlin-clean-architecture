package com.zigzag.crm.usecase.lead.impl

import com.zigzag.crm.framework.domain.api.features.lead.IProductRepository
import com.zigzag.crm.usecase.lead.dto.ProductDto
import com.zigzag.crm.usecase.product.api.Usecase_FindProductById
import com.zigzag.crm.usecase.product.mapper.ProductMapper
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class Usecase_FindProductById_Impl(
    private val productRepository: IProductRepository,
    private val productMapper: ProductMapper
) : Usecase_FindProductById {
    override fun execute(id: String): Mono<ProductDto.Response.Public> {
        val lead = productRepository.findById(id);
        return lead.map{productMapper.convertEntityToDto(it)}
    }
}
