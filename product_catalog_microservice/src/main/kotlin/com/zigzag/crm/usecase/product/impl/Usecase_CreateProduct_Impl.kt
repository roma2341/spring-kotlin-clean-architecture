package com.zigzag.crm.usecase.product.impl

import com.zigzag.crm.framework.domain.api.features.lead.IProductRepository
import com.zigzag.crm.usecase.lead.dto.ProductDto
import com.zigzag.crm.usecase.product.api.Usecase_CreateProduct
import com.zigzag.crm.usecase.product.mapper.ProductMapper
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class Usecase_CreateProduct_Impl(
    private val productRepository: IProductRepository,
    private val productMapper: ProductMapper
): Usecase_CreateProduct {
    override fun execute(leadDto: ProductDto.Request.Create): Mono<ProductDto.Response.Public> {
        var user = productMapper.convertDtoToEntity(leadDto);
        var persistedUser = productRepository.createProduct(user);
        return persistedUser.map{lead -> productMapper.convertEntityToDto(lead)};
    }
}
