package com.example.tripquote.data.remote

import com.example.tripquote.data.model.Quote
import retrofit2.http.GET

interface ApiService {
    @GET("NjokiCynthia/5abfd25114d524c55880f0833f3f97d3/raw/8dbf10ac1b52b95fb6801950e3c6b241b70a3401/quote.json")

    suspend fun getSampleQuote(): Quote
}