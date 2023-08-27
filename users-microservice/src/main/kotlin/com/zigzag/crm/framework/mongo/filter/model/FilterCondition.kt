package com.zigzag.crm.framework.mongo.filter.model

import com.zigzag.crm.framework.mongo.filter.enums.FilterOperator

data class FilterCondition( val field: String, val value: String, val operator: FilterOperator)
