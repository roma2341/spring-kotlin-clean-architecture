package com.zigzag.crm.module.mongo.repository.product

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("product")
data class CrmProductDocument(
    @Id
    val id:String?,
    val description: String?,
    val name: String?
)
