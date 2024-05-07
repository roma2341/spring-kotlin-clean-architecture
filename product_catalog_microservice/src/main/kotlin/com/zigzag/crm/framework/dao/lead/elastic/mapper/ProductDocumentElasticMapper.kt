package com.zigzag.crm.framework.dao.lead.elastic.mapper

import com.zigzag.crm.framework.dao.lead.elastic.ProductElasticDocument
import com.zigzag.crm.framework.domain.api.features.lead.Product

interface ProductDocumentElasticMapper {
        fun convertDocumentToEntity(document: ProductElasticDocument): Product
        fun convertEntityToDocument(product: Product): ProductElasticDocument
}