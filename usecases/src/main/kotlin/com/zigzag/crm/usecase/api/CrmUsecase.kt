package com.zigzag.crm.usecase.api

import org.springframework.stereotype.Component

@Component
interface CrmUsecase<Result, Argument> {
    fun execute(arg: Argument): Result
}
