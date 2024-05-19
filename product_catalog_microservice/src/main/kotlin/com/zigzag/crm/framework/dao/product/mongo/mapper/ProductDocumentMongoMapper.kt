package com.zigzag.crm.framework.dao.product.mongo.mapper

import com.zigzag.crm.framework.domain.api.features.lead.Product
import com.zigzag.crm.framework.dao.product.mongo.ProductMongoDocument

interface ProductDocumentMongoMapper {
        fun convertDocumentToEntity(document: ProductMongoDocument): Product
        fun convertEntityToDocument(product: Product): ProductMongoDocument
}
