package com.zigzag.crm.domain.shipping

import com.zigzag.crm.domain.address.Address

data class Shipping(
    val address: Address,
    val origin: Address,
    val carrier: String,
    val tracking: String
)