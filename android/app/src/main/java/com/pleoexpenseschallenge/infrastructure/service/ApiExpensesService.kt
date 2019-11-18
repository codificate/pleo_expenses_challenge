package com.pleoexpenseschallenge.infrastructure.service

import com.pleoexpenseschallenge.domain.model.User
import com.pleoexpenseschallenge.domain.model.Amount
import com.pleoexpenseschallenge.domain.model.Expense
import com.pleoexpenseschallenge.domain.model.PleoExpenses
import com.pleoexpenseschallenge.domain.service.ExpensesService
import com.pleoexpenseschallenge.infrastructure.response.ExpensesResponse
import io.reactivex.Maybe

class ApiExpensesService(private val client: ApiExpensesClient): ExpensesService {

    override fun getExpenses(): Maybe<PleoExpenses> {
        return client.fetchExpenses().map { it.toPleoExpenses() }
    }

    private fun ExpensesResponse.toPleoExpenses(): PleoExpenses {
        return PleoExpenses(this.expenses.map { Expense(it.id,
                Amount(it.amount.currency, it.amount.value),
                it.comment, User(it.user.email, it.user.first, it.user.last),
                it.date, it.merchant) }.toMutableList(), this.total)
    }
}