package com.zigzag.crm.core.config

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@Configuration
@EnableReactiveMongoRepositories("com.zigzag.crm")
class CrmDaoConfig: AbstractReactiveMongoConfiguration() {
    @Value("\${crm.mongo.connection}")
    private val mongoConnection: String? = null

    @Value("\${crm.mongo.name}")
    private val mongoDatabaseName: String? = null

    @Bean
    override fun reactiveMongoClient(): MongoClient? {
        return MongoClients.create(mongoConnection);
    }

    override fun getDatabaseName(): String? {
        return mongoDatabaseName;
    }
}
