package com.pleoexpenseschallenge.domain.action

import com.pleoexpenseschallenge.domain.model.PleoExpenses
import com.pleoexpenseschallenge.domain.service.ExpensesService
import io.reactivex.Maybe

class FetchExpenses(private val expensesService: ExpensesService) {
    operator fun invoke(): Maybe<PleoExpenses> {
        return expensesService.getExpenses()
    }
}