package com.pleoexpenseschallenge.infrastructure.service

import com.pleoexpenseschallenge.domain.model.User
import com.pleoexpenseschallenge.domain.model.Amount
import com.pleoexpenseschallenge.domain.model.Expense
import com.pleoexpenseschallenge.domain.model.PleoExpenses
import com.pleoexpenseschallenge.domain.service.ExpensesService
import com.pleoexpenseschallenge.infrastructure.response.ExpensesResponse
import io.reactivex.Maybe
import java.text.SimpleDateFormat
import java.util.*

class ApiExpensesService(private val client: ApiExpensesClient): ExpensesService {

    override fun getExpenses(limit: Int, offset: Int): Maybe<PleoExpenses> {
        return client.fetchExpenses(limit, offset).map { it.toPleoExpenses() }
    }

    private fun ExpensesResponse.toPleoExpenses(): PleoExpenses {
        return PleoExpenses(this.expenses.map { Expense(it.id,
                Amount(it.amount.currency, it.amount.value.toDouble()),
                it.comment, User(it.user.email, it.user.first, it.user.last),
                it.date.toDate(), it.merchant, it.index) }.toMutableList(), this.total)
    }

    private fun String.toDate(): Date{
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
        return format.parse(this)
    }
}