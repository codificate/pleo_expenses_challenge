package com.pleoexpenseschallenge.infrastructure.service

import com.pleoexpenseschallenge.infrastructure.response.ExpensesResponse
import io.reactivex.Maybe
import retrofit2.http.GET

interface ApiExpensesClient {
    @GET("expenses")
    fun fetchExpenses(): Maybe<ExpensesResponse>
}