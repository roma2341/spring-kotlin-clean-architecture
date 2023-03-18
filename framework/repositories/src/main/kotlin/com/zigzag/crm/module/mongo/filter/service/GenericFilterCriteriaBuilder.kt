package com.zigzag.crm.module.mongo.filter.service

import com.zigzag.crm.module.mongo.filter.enums.FilterOperator
import com.zigzag.crm.module.mongo.filter.model.FilterCondition
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import java.util.*
import java.util.function.Function
import java.util.stream.Collectors
import kotlin.collections.ArrayList

/**
 * This class is used to build all the queries passed as parameters.
 * filterAndConditions (filter list for the AND operator)
 * filterOrConditions (filter list for the OR operator)
 */
class GenericFilterCriteriaBuilder {
    private val filterAndConditions: MutableList<FilterCondition>
    private val filterOrConditions: MutableList<FilterCondition>

    init {
        filterOrConditions = ArrayList<FilterCondition>()
        filterAndConditions = ArrayList<FilterCondition>()
    }

    fun addCondition(andConditions: List<FilterCondition>?, orConditions: List<FilterCondition>?): Query {
        if (andConditions != null && !andConditions.isEmpty()) {
            filterAndConditions.addAll(andConditions)
        }
        if (orConditions != null && !orConditions.isEmpty()) {
            filterOrConditions.addAll(orConditions)
        }
        val criteriaAndClause: MutableList<Criteria> = ArrayList()
        val criteriaOrClause: MutableList<Criteria> = ArrayList()
        val criteria = Criteria()

        // build criteria
        filterAndConditions.stream().map(Function<FilterCondition, Boolean> { condition: FilterCondition ->
            criteriaAndClause.add(
                buildCriteria(condition)
            )
        }).collect(Collectors.toList())
        filterOrConditions.stream().map(Function<FilterCondition, Boolean> { condition: FilterCondition ->
            criteriaOrClause.add(
                buildCriteria(condition)
            )
        }).collect(Collectors.toList())
        return if (!criteriaAndClause.isEmpty() && !criteriaOrClause.isEmpty()) {
            Query(criteria.andOperator(*criteriaAndClause.toTypedArray()).orOperator(*criteriaOrClause.toTypedArray()))
        } else if (!criteriaAndClause.isEmpty()) {
            Query(criteria.andOperator(*criteriaAndClause.toTypedArray()))
        } else if (!criteriaOrClause.isEmpty()) {
            Query(criteria.orOperator(*criteriaOrClause.toTypedArray()))
        } else {
            Query()
        }
    }

    /**
     * Build the predicate according to the request
     *
     * @param condition The condition of the filter requested by the query
     * @return {[Criteria]}
     */
    private fun buildCriteria(condition: FilterCondition): Criteria {
        val function: Function<FilterCondition, Criteria> = FILTER_CRITERIA[condition.operator.name()]
            ?: throw IllegalArgumentException("Invalid function param type: ")
        return function.apply(condition)
    }

    companion object {
        private val FILTER_CRITERIA = EnumMap<FilterOperator, Function<FilterCondition, Criteria>>(FilterOperator::class.java)

        // Create map of filter
        init {
            FILTER_CRITERIA.put(FilterOperator.EQUAL) { condition ->
                Criteria.where(condition.field).`is`(condition.value)
            }
            FILTER_CRITERIA.put(FilterOperator.NOT_EQUAL) { condition ->
                Criteria.where(condition.field).ne(condition.value)
            }
            FILTER_CRITERIA.put(FilterOperator.GREATER_THAN) { condition ->
                Criteria.where(condition.field).gt(condition.value)
            }
            FILTER_CRITERIA.put(FilterOperator.GREATER_THAN_OR_EQUAL_TO) { condition ->
                Criteria.where(condition.field).gte(condition.value)
            }
            FILTER_CRITERIA.put(FilterOperator.LESS_THAN) { condition ->
                Criteria.where(condition.field).lt(condition.value)
            }
            FILTER_CRITERIA.put(FilterOperator.LESSTHAN_OR_EQUAL_TO) { condition ->
                Criteria.where(condition.field).lte(condition.value)
            }
            FILTER_CRITERIA.put(FilterOperator.CONTAINS) { condition ->
                Criteria.where(condition.field).regex(condition.value as String)
            }
            FILTER_CRITERIA.put(FilterOperator.JOIN) { condition -> Criteria.where(condition.field).`is`(condition.value) }
        }
    }
}
