package com.zigzag.crm.domain.order

import com.zigzag.crm.domain.enums.PaymentStatus
import com.zigzag.crm.domain.order.enums.OrderStatus
import com.zigzag.crm.domain.shipping.Shipping

data class Order(
    val id: String? = null,
    val customerId: String,
    val paymentId: String? = null,
    val paymentStatus: PaymentStatus,
    val status: OrderStatus? = null,
    val customId: String? = null,
    val currency: String? = null,
    val items: Set<String>,
    val shipping: Shipping
)