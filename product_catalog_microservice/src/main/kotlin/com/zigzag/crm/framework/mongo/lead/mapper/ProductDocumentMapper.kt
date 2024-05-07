package com.zigzag.crm.framework.mongo.lead.mapper

import com.zigzag.crm.framework.domain.api.features.lead.Product
import com.zigzag.crm.framework.mongo.lead.ProductDocument

interface ProductDocumentMapper {
        fun convertDocumentToEntity(document: ProductDocument): Product
        fun convertEntityToDocument(lead: Product): ProductDocument
}
