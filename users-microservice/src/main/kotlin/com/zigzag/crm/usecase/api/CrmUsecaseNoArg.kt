package com.zigzag.crm.usecase.api

import org.springframework.stereotype.Component

@Component
interface CrmUsecaseNoArg<Result> {
    fun execute(): Result
}
