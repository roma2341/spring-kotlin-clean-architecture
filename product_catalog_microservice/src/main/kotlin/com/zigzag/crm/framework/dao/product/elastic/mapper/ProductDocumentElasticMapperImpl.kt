package com.zigzag.crm.framework.dao.product.elastic.mapper

import com.zigzag.crm.framework.dao.product.elastic.ProductElasticDocument
import com.zigzag.crm.framework.domain.api.features.lead.Product
import org.springframework.stereotype.Component

@Component
class ProductDocumentElasticMapperImpl : ProductDocumentElasticMapper {
    override fun convertDocumentToEntity(document: ProductElasticDocument): Product {
        return Product(
            id = document.id,
            name = document.name
        )
    }

    override fun convertEntityToDocument(product: Product): ProductElasticDocument {
        return ProductElasticDocument(
            id = product.id,
            name = product.name
        )
    }
}