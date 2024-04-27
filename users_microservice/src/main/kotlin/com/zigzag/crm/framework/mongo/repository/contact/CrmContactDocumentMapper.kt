package com.zigzag.crm.framework.mongo.repository.contact

import com.zigzag.crm.framework.domain.api.features.contact.CrmContact

abstract class CrmContactDocumentMapper {
 companion object {
     fun convertDocumentToEntity(document: CrmContactDocument): CrmContact{
         return CrmContact(
             id = document.id,
             firstName = document.firstName,
             lastName = document.lastName,
             email = document.email,
             phone = document.phone,
             ownerId = null
         )
     }
     fun convertEntityToDocument(entity: CrmContact): CrmContactDocument{
         return CrmContactDocument(
             entity.id,
             entity.firstName,
             entity.lastName,
             entity.email,
             entity.phone
         )
     }
 }
}
