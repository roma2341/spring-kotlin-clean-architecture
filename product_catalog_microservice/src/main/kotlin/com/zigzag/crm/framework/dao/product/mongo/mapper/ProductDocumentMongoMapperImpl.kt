package com.zigzag.crm.framework.dao.product.mongo.mapper

import com.zigzag.crm.framework.domain.api.features.lead.Product
import com.zigzag.crm.framework.dao.product.mongo.ProductMongoDocument
import org.springframework.stereotype.Component

@Component
class ProductDocumentMongoMapperImpl: ProductDocumentMongoMapper {
        override fun convertDocumentToEntity(document: ProductMongoDocument): Product {
            return Product(
                id = document.id,
                name = document.name
            )
        }

    override fun convertEntityToDocument(product: Product): ProductMongoDocument {
            return ProductMongoDocument(
                id = product.id,
                name = product.name
            )
        }
}
