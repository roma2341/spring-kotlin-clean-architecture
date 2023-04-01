package com.zigzag.crm.usecase.core.api

import org.springframework.stereotype.Component

@Component
interface CrmUsecaseNoArg<Result> {
    fun execute(): Result
}
