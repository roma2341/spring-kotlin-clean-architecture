package com.zigzag.crm.framework.domain.api.features.contact

import reactor.core.publisher.Mono

interface ICrmContactRepository {
    fun createContact(contact: CrmContact): Mono<CrmContact>;
}
