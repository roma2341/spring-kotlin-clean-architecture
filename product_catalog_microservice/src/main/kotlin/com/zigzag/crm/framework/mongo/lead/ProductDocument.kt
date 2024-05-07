package com.zigzag.crm.framework.mongo.lead

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("product")
data class ProductDocument(
    @Id
    val id:String?,
    val name:String?)
