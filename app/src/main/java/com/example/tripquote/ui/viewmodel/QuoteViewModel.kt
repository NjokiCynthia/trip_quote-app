package com.example.tripquote.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tripquote.data.model.Quote
import com.example.tripquote.data.repository.QuoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class QuoteViewModel(private val repository: QuoteRepository) : ViewModel() {

    private val _quote = MutableStateFlow<Quote?>(null)
    val quote: StateFlow<Quote?> = _quote

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun getQuote() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _quote.value = repository.fetchQuote()
            } catch (e: Exception) {
                // Handle error appropriately (log or fallback)
            } finally {
                _isLoading.value = false
            }
        }
    }
}