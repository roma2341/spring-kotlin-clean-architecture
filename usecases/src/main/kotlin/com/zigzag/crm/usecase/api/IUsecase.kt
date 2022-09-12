package com.zigzag.crm.usecase.api

import org.springframework.stereotype.Component

@Component
interface IUsecase<Result, Argument> {
    fun execute(argument: Argument): Result
}
