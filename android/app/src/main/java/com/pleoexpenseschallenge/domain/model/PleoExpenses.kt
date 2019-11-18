package com.pleoexpenseschallenge.domain.model

data class PleoExpenses(val listExpens: MutableList<Expense>,
                        val total: Int)