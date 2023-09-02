package org.zigzag.crm.common.usecase

import org.springframework.stereotype.Component

@Component
interface CrmUsecase<Result, Argument> {
    fun execute(arg: Argument): Result
}
