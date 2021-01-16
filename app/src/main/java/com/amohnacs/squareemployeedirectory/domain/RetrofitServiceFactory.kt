package com.amohnacs.squareemployeedirectory.domain

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServiceFactory {
    private const val BASE_URL = "https://s3.amazonaws.com/"

    private val amiiboBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())

    private var retrofit = amiiboBuilder.build()

    private val httpClient = OkHttpClient.Builder()

    private val logging = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    fun <S> createAmiiboService(serviceClass: Class<S>): S {
        if (!httpClient.interceptors().contains(logging)) {
            httpClient.addInterceptor(logging)
            amiiboBuilder.client(httpClient.build())
            retrofit = amiiboBuilder.build()
        }
        return retrofit.create(serviceClass)
    }
}