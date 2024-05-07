package com.zigzag.crm.framework.config.elastic

import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories

@Configuration
@EnableReactiveElasticsearchRepositories(basePackages = ["com.zigzag.crm"])
class ElasticSearchConfig {
}