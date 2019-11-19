package com.pleoexpenseschallenge.domain.model

import java.util.*

data class Expense(
        val id: String, val amount: Amount,
        val comment: String, val user: User,
        val date: Date, val merchant: String, val index: Int)

data class Amount(val currency: String, val value: Double)

data class User(val email: String, val first: String, val last: String)