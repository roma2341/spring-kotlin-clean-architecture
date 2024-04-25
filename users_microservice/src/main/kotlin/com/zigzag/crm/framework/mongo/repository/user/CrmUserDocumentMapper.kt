package com.zigzag.crm.framework.mongo.repository.user

import com.zigzag.crm.framework.domain.api.features.user.CrmUser
import io.mcarle.konvert.api.Konverter
import io.mcarle.konvert.injector.spring.KComponent

@Konverter
@KComponent
interface CrmUserDocumentMapper {
    fun convertDocumentToUser(document: CrmUserDocument): CrmUser
    fun convertUserToDocument(user: CrmUser): CrmUserDocument
}
