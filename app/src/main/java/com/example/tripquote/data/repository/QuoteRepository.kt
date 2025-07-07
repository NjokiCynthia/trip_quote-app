package com.example.tripquote.data.repository

import com.example.tripquote.data.model.Quote
import com.example.tripquote.data.remote.ApiService

class QuoteRepository(private val apiService: ApiService) {
    suspend fun fetchQuote(): Quote {
        return apiService.getSampleQuote()
    }
}
