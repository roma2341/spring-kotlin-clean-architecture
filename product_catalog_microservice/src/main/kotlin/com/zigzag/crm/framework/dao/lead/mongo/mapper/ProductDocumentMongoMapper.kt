package com.zigzag.crm.framework.dao.lead.mongo.mapper

import com.zigzag.crm.framework.domain.api.features.lead.Product
import com.zigzag.crm.framework.dao.lead.mongo.ProductMongoDocument

interface ProductDocumentMongoMapper {
        fun convertDocumentToEntity(document: ProductMongoDocument): Product
        fun convertEntityToDocument(product: Product): ProductMongoDocument
}
