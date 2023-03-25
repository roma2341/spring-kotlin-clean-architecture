package com.zigzag.crm.framework.domain.api.features.product

import com.zigzag.crm.framework.domain.api.features.user.CrmUser
import reactor.core.publisher.Mono

interface ICrmProductRepository {
    fun createProduct(product: CrmProduct): Mono<CrmProduct>;
}
