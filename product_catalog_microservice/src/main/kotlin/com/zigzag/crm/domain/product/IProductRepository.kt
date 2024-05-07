package com.zigzag.crm.framework.domain.api.features.lead

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


interface IProductRepository {

    fun updateProduct(product: Product): Mono<Product>;
    fun createProduct(product: Product): Mono<Product>;
    fun findById(id: String): Mono<Product>;
    fun findAll(): Flux<Product>;
    fun find(searchValue: String): Flux<Product>
}
