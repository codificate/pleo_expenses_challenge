package com.pleoexpenseschallenge.domain.service

import com.pleoexpenseschallenge.domain.model.PleoExpenses
import io.reactivex.Maybe

interface ExpensesService {
    fun getExpenses(limit: Int, offset: Int): Maybe<PleoExpenses>
}