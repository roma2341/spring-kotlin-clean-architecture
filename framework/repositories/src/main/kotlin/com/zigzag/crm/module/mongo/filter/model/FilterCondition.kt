package com.zigzag.crm.module.mongo.filter.model

import com.zigzag.crm.module.mongo.filter.enums.FilterOperator

data class FilterCondition( val field: String, val value: String, val operator: FilterOperator)
