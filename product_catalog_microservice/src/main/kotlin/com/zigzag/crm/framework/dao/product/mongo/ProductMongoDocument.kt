package com.zigzag.crm.framework.dao.product.mongo

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("product")
data class ProductMongoDocument(
    @Id
    val id:String?,
    val name:String?)
