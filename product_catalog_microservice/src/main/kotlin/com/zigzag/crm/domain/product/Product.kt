package com.zigzag.crm.framework.domain.api.features.lead

import com.zigzag.crm.domain.product.ProductPrice

data class Product(
    var id: String? = null,
    var name: String? = null,
    var price: ProductPrice? = null,
    var quantity: Int? = null
)
