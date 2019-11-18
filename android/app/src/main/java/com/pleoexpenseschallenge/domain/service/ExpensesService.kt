package com.pleoexpenseschallenge.domain.service

import com.pleoexpenseschallenge.domain.model.PleoExpenses
import io.reactivex.Maybe

interface ExpensesService {
    fun getExpenses(): Maybe<PleoExpenses>
}