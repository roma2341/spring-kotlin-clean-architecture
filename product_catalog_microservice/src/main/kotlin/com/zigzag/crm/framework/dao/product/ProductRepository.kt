package com.zigzag.crm.framework.dao.product

import com.zigzag.crm.framework.domain.api.features.lead.IProductRepository
import com.zigzag.crm.framework.domain.api.features.lead.Product
import com.zigzag.crm.framework.dao.product.elastic.ProductElasticRepository
import com.zigzag.crm.framework.dao.product.elastic.mapper.ProductDocumentElasticMapper
import com.zigzag.crm.framework.dao.product.mongo.mapper.ProductDocumentMongoMapper
import com.zigzag.crm.framework.dao.product.mongo.ProductRepositoryMongoHelper
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class ProductRepository(
    private val productRepositoryMongoHelper: ProductRepositoryMongoHelper,
    private val productDocumentMongoMapper: ProductDocumentMongoMapper,
    private val productElasticRepository: ProductElasticRepository,
    private val productElasticMapper: ProductDocumentElasticMapper
) : IProductRepository {
    override fun updateProduct(product: Product): Mono<Product> {
        if(product.id == null) {
            throw RuntimeException("Cannot update lead if empty id")
        }
        val document = productDocumentMongoMapper.convertEntityToDocument(product);
        return productRepositoryMongoHelper.save(document).map { u -> productDocumentMongoMapper.convertDocumentToEntity(u); };
    }

    override fun createProduct(lead: Product): Mono<Product> {
        if(lead.id != null) {
            throw RuntimeException("Cannot create lead with non-empty id")
        }
        val document = productDocumentMongoMapper.convertEntityToDocument(lead);
        return productRepositoryMongoHelper.save(document).map { u -> productDocumentMongoMapper.convertDocumentToEntity(u); }
    }

    override fun findById(id: String): Mono<Product> {
        return productRepositoryMongoHelper.findById(id).map { u -> productDocumentMongoMapper.convertDocumentToEntity(u) }
    }

    override fun findAll(): Flux<Product> {
        return productRepositoryMongoHelper.findAll().map { u -> productDocumentMongoMapper.convertDocumentToEntity(u)}
    }

    override fun find(searchTerms: String): Flux<Product> {
        return productElasticRepository.findByAllUsingCustomQuery(searchTerms, PageRequest.of(0,25))
            .map{ doc -> productElasticMapper.convertDocumentToEntity(doc)};
    };

}
