package com.pleoexpenseschallenge.retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RestModule {

    fun <T> createClient(clientClass: Class<T>): T {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(createHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(clientClass)
    }

    private fun createHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor {
            chain: Interceptor.Chain ->
            val request = chain.request().newBuilder()
                    .addHeader("Accept", "application/json").build()
            return@addInterceptor chain.proceed(request)
        }
        return builder.build()
    }
}