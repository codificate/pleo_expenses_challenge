package com.pleoexpenseschallenge.domain.factory

import com.pleoexpenseschallenge.domain.action.FetchExpenses
import com.pleoexpenseschallenge.infrastructure.factory.RetrofitExpensesFactory

fun createFetchExpensesAction(): FetchExpenses{
    return FetchExpenses(RetrofitExpensesFactory.createApiExpensesService())
}