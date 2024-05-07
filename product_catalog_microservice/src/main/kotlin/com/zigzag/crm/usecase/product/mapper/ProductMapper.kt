package com.zigzag.crm.usecase.product.mapper

import com.zigzag.crm.framework.domain.api.features.lead.Product
import com.zigzag.crm.usecase.lead.dto.ProductDto

interface  ProductMapper {
       fun convertDtoToEntity(productDto: ProductDto.Request.Create): Product
       fun convertEntityToDto(product: Product): ProductDto.Response.Public
}

