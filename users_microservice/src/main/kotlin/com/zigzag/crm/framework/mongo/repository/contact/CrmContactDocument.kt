package com.zigzag.crm.framework.mongo.repository.contact

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("contact")
data class CrmContactDocument(
    @Id
    val id:String?,
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val phone: String?
)
