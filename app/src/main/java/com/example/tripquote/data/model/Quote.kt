// 1. Updated Quote.kt model
package com.example.tripquote.data.model

data class Quote(
    val destination: String,
    val travelDate: String,
    val travellers: Int,
    val totalCost: String,
    val imageUrl: String
)