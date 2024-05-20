package com.zigzag.crm.domain.payment

import com.zigzag.crm.domain.credit.card.CreditCard

data class Payment(
    val id: String,
    val customerId: String,
    val status: String,
    val gateway: String,
    val type: String,
    val amount: Double,
    val card: CreditCard
)