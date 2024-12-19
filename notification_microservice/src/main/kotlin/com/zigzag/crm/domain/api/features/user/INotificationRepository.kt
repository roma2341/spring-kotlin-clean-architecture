package com.zigzag.crm.framework.domain.api.features.user

import com.zigzag.crm.framework.domain.api.features.user.CrmUser
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import javax.management.Notification


interface INotificationRepository {
    fun createNotification(user: Notification): Mono<Notification>;
    fun findById(id: String): Mono<Notification>;
    fun findAll(): Flux<Notification>;
    fun findFirst(): Mono<Notification>;
}
