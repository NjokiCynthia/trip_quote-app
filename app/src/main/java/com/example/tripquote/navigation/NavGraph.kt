package com.example.tripquote.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tripquote.ui.screens.LandingScreen
import com.example.tripquote.ui.screens.QuoteDetailScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "landing") {
        composable("landing") { LandingScreen(navController) }
        composable("quote") { QuoteDetailScreen() }
    }
}
