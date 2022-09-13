package com.zigzag.crm.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("user")
data class CrmUserDocument(
    @Id
    val id:String?,
    val firstName:String,
    val lastName:String,
    val email:String)
