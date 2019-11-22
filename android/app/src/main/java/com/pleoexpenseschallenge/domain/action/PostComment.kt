package com.pleoexpenseschallenge.domain.action

import com.pleoexpenseschallenge.domain.service.ExpensesService
import com.pleoexpenseschallenge.infrastructure.request.CommentBody
import io.reactivex.Completable

class PostComment(private val expensesService: ExpensesService) {
    operator fun invoke(id: String, comment: String): Completable {
        return expensesService.setComment(id, CommentBody(comment))
    }
}