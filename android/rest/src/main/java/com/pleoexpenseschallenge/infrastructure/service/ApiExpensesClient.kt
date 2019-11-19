package com.pleoexpenseschallenge.infrastructure.service

import com.pleoexpenseschallenge.infrastructure.response.ExpensesResponse
import io.reactivex.Maybe
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiExpensesClient {
    @GET("expenses")
    fun fetchExpenses(
            @Query("limit") limit: Int,
            @Query("offset") offset: Int
    ): Maybe<ExpensesResponse>
}