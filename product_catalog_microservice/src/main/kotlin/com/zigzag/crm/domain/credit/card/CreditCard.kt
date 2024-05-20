package com.zigzag.crm.domain.credit.card

data class CreditCard(
    val brand: String,
    val pinLastFour: String,
    val expirationMonth: Int,
    val expirationYear: Int,
    val cvvVerified: Boolean,
    val token: String
)