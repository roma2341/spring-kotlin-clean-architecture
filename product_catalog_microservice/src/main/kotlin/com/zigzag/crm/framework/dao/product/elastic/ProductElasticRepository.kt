package com.zigzag.crm.framework.dao.product.elastic

import org.springframework.data.domain.Pageable
import org.springframework.data.elasticsearch.annotations.Query
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface ProductElasticRepository: ReactiveElasticsearchRepository<ProductElasticDocument, String> {
    @Query(value = """
    SELECT p FROM product p
    """)
    fun findByAllUsingCustomQuery(name: String, pageable: Pageable): Flux<ProductElasticDocument>
}