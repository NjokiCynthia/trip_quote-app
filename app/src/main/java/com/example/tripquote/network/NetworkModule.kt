package com.example.tripquote.network

import com.example.tripquote.data.remote.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    private const val BASE_URL = "https://gist.githubusercontent.com/"

    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
