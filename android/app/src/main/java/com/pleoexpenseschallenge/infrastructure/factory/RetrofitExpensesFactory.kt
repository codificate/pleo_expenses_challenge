package com.pleoexpenseschallenge.infrastructure.factory

import com.pleoexpenseschallenge.infrastructure.service.ApiExpensesClient
import com.pleoexpenseschallenge.infrastructure.service.ApiExpensesService
import com.pleoexpenseschallenge.retrofit.RestModule

object RetrofitExpensesFactory {

    private val client: ApiExpensesClient

    init {
        client = expensesClient()
    }

    fun createApiExpensesService(): ApiExpensesService {
        return ApiExpensesService(client)
    }

    private fun expensesClient(): ApiExpensesClient {
        return RestModule
                .createClient(ApiExpensesClient::class.java)
    }
}