package org.zigzag.crm.common.mongo.filter.model

import org.zigzag.crm.common.mongo.filter.enums.FilterOperator

data class FilterCondition( val field: String, val value: String, val operator: FilterOperator)
