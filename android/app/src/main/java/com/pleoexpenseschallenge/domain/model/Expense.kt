package com.pleoexpenseschallenge.domain.model

data class Expense(
        val id: String, val amount: Amount,
        val comment: String, val user: User,
        val date: String, val merchant: String)

data class Amount(val currency: String, val value: String)

data class User(val email: String, val first: String, val last: String)