package com.zigzag.crm.domain.address

data class Address (
    val street: String? = null,
    val city: String? = null,
    val province: String? = null,
    val country: String? = null,
    val zip: String? = null,
)