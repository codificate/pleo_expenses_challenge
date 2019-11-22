package com.pleoexpenseschallenge.domain.factory

import com.pleoexpenseschallenge.domain.action.FetchExpenses
import com.pleoexpenseschallenge.domain.action.PostComment
import com.pleoexpenseschallenge.infrastructure.factory.RetrofitExpensesFactory

fun createFetchExpensesAction(): FetchExpenses{
    return FetchExpenses(RetrofitExpensesFactory.createApiExpensesService())
}

fun createPostCommentAction(): PostComment {
    return PostComment(RetrofitExpensesFactory.createApiExpensesService())
}