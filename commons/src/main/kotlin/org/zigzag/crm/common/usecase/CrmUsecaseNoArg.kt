package org.zigzag.crm.common.usecase

interface CrmUsecaseNoArg<Result> {
    fun execute(): Result
}
