package com.zigzag.crm.framework.mongo.lead.mapper

import com.zigzag.crm.framework.domain.api.features.lead.Product
import com.zigzag.crm.framework.mongo.lead.ProductDocument
import org.springframework.stereotype.Component

@Component
class ProductDocumentMapperImpl:ProductDocumentMapper {
        override fun convertDocumentToEntity(document: ProductDocument): Product {
            return Product(
                id = document.id,
                name = document.name
            )
        }

    override fun convertEntityToDocument(product: Product): ProductDocument {
            return ProductDocument(
                id = product.id,
                name = product.name
            )
        }
}
