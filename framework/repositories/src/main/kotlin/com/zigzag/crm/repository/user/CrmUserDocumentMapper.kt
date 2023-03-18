package com.zigzag.crm.repository.user

import com.zigzag.crm.repository.user.CrmUserDocument
import com.zigzag.crm.framework.domain.api.features.user.CrmUser
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface CrmUserDocumentMapper {
    fun convertDocumentToUser(document: CrmUserDocument): CrmUser
    fun convertUserToDocument(user: CrmUser): CrmUserDocument
}
