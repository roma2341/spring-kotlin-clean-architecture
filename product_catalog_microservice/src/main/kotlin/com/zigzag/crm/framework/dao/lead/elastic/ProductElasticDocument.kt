package com.zigzag.crm.framework.dao.lead.elastic

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "product")
data class ProductElasticDocument(
    @Id
     val id: String? = null,
     val name: String? = null
)