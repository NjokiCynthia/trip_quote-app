package com.example.tripquote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.tripquote.navigation.NavGraph
import com.example.tripquote.ui.theme.TripQuoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripQuoteTheme {
                NavGraph()
            }
        }
    }
}
