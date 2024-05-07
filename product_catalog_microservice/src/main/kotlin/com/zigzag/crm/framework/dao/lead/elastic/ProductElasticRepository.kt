package com.zigzag.crm.framework.dao.lead.elastic

import org.springframework.data.domain.Pageable
import org.springframework.data.elasticsearch.annotations.Query
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository
import reactor.core.publisher.Flux

interface ProductElasticRepository: ReactiveElasticsearchRepository<ProductElasticDocument, String> {
    @Query("""{
  "query": {
    "match": {
      "_all": "?0"
    }
  }
}
    """)
    fun findByAllUsingCustomQuery(name: String, pageable: Pageable): Flux<ProductElasticDocument>
}