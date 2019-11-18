package com.pleoexpenseschallenge.infrastructure.response

data class ExpensesResponse(
        val expenses: List<Expense>,
        val total: Int
)