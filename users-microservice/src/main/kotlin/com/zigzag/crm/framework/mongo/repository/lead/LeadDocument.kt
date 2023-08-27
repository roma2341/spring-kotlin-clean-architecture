package com.zigzag.crm.framework.mongo.repository.lead

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("lead")
data class LeadDocument(
    @Id
    val id:String?,
    val firstName:String?,
    val lastName:String?,
    val email:String?)
