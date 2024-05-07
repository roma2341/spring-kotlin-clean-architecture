package com.zigzag.crm.usecase.lead.mapper

import com.zigzag.crm.framework.domain.api.features.lead.Product
import com.zigzag.crm.usecase.lead.dto.ProductDto
import com.zigzag.crm.usecase.product.mapper.ProductMapper
import org.springframework.stereotype.Component

@Component
class ProductMapperImpl : ProductMapper {
    override fun convertDtoToEntity(productDto: ProductDto.Request.Create): Product {
        return Product(
            name = productDto.name
        )
    }
    override fun convertEntityToDto(product: Product): ProductDto.Response.Public {
        return ProductDto.Response.Public(
            id = product.id,
            name = product.name
        )
    }
}