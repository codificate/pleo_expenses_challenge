package com.pleoexpenseschallenge.infrastructure.response

data class Expense(
        val amount: Amount,
        val category: String,
        val comment: String,
        val date: String,
        val id: String,
        val index: Int,
        val merchant: String,
        val receipts: List<Any>,
        val user: User
)