package com.zigzag.crm.framework.domain.api.features.contact

import com.zigzag.crm.framework.domain.api.features.product.CrmProduct
import reactor.core.publisher.Mono

interface ICrmContactRepository {
    fun createContact(contact: CrmContact): Mono<CrmContact>;
}
