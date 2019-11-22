package com.pleoexpenseschallenge.domain.service

import com.pleoexpenseschallenge.domain.model.PleoExpenses
import com.pleoexpenseschallenge.infrastructure.request.CommentBody
import io.reactivex.Completable
import io.reactivex.Maybe

interface ExpensesService {
    fun getExpenses(limit: Int, offset: Int): Maybe<PleoExpenses>
    fun setComment(id: String, commentBody: CommentBody): Completable
}