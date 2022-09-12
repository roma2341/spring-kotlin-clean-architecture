package com.zigzag.crm.usecase.api

import org.springframework.stereotype.Component

@Component
interface IUsecaseNoArg<Result> {
    fun execute(): Result
}
