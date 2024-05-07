package com.zigzag.crm.framework.mongo.lead

import com.zigzag.crm.framework.domain.api.features.lead.IProductRepository
import com.zigzag.crm.framework.domain.api.features.lead.Product
import com.zigzag.crm.framework.mongo.lead.mapper.ProductDocumentMapper
import org.springframework.data.domain.Example
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class ProductRepository(
    private val productRepositoryMongoHelper: ProductRepositoryMongoHelper,
    private val productDocumentMapper: ProductDocumentMapper
) : IProductRepository {
    override fun updateProduct(product: Product): Mono<Product> {
        if(product.id == null) {
            throw RuntimeException("Cannot update lead if empty id")
        }
        val document = productDocumentMapper.convertEntityToDocument(product);
        return productRepositoryMongoHelper.save(document).map { u -> productDocumentMapper.convertDocumentToEntity(u); };
    }

    override fun createProduct(lead: Product): Mono<Product> {
        if(lead.id != null) {
            throw RuntimeException("Cannot create lead with non-empty id")
        }
        val document = productDocumentMapper.convertEntityToDocument(lead);
        return productRepositoryMongoHelper.save(document).map { u -> productDocumentMapper.convertDocumentToEntity(u); }
    }

    override fun findById(id: String): Mono<Product> {
        return productRepositoryMongoHelper.findById(id).map { u -> productDocumentMapper.convertDocumentToEntity(u) }
    }

    override fun findAll(): Flux<Product> {
        return productRepositoryMongoHelper.findAll().map { u -> productDocumentMapper.convertDocumentToEntity(u)}
    }

    override fun find(searchTerms: String): Flux<Product> {
        return productRepositoryMongoHelper.findAll()
            .map{ doc -> productDocumentMapper.convertDocumentToEntity(doc)};
    };

}
