package com.zigzag.crm.framework.mongo.repository.user

import com.zigzag.crm.framework.domain.api.features.user.CrmUser
import io.mcarle.konvert.api.Konverter
import io.mcarle.konvert.injector.spring.KComponent

abstract class CrmUserDocumentMapper {
    companion object {
        fun convertDocumentToUser(document: CrmUserDocument): CrmUser {
            return CrmUser(
                id = document.id,
                firstName = document.firstName,
                lastName = document.lastName,
                email = document.email
            )
        }
        fun convertUserToDocument(user: CrmUser): CrmUserDocument {
            return CrmUserDocument(id = user.id,
                firstName = user.firstName,
                lastName = user.lastName,
                email = user.email
            )
        }
    }
}
