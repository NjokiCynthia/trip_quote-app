package com.example.tripquote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.tripquote.navigation.NavGraph
import com.example.tripquote.ui.theme.TripQuoteTheme
import com.example.tripquote.data.repository.QuoteRepository
import com.example.tripquote.network.NetworkModule
import com.example.tripquote.ui.viewmodel.QuoteViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val api = NetworkModule.provideApiService()
        val repository = QuoteRepository(api)
        val viewModel = QuoteViewModel(repository)


        setContent {
            TripQuoteTheme {
                NavGraph(viewModel = viewModel)
            }
        }
    }
}
