package com.pleoexpenseschallenge.infrastructure.service

import com.pleoexpenseschallenge.infrastructure.request.CommentBody
import com.pleoexpenseschallenge.infrastructure.response.ExpensesResponse
import io.reactivex.Completable
import io.reactivex.Maybe
import retrofit2.http.*

interface ApiExpensesClient {
    @GET("expenses")
    fun fetchExpenses(
            @Query("limit") limit: Int,
            @Query("offset") offset: Int
    ): Maybe<ExpensesResponse>

    @POST("expenses/{id}")
    fun setComment(@Path("id") id: String, @Body commentBody: CommentBody): Completable
}