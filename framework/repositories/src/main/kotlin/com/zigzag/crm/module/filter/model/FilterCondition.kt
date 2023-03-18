package com.zigzag.crm.module.filter.model

import com.zigzag.crm.module.filter.enums.FilterOperator

data class FilterCondition( val field: String, val value: String, val operator: FilterOperator)
