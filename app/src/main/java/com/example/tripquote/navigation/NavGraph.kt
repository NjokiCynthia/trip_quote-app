package com.example.tripquote.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tripquote.ui.screens.LandingScreen
import com.example.tripquote.ui.screens.QuoteDetailScreen
import com.example.tripquote.ui.viewmodel.QuoteViewModel

@Composable
fun NavGraph(
    viewModel: QuoteViewModel, // 🔹 ViewModel passed in from MainActivity
) {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "landing") {

        // Landing screen receives navController for navigation
        composable("landing") {
            LandingScreen(navController)
        }

        // Quote screen receives both viewModel and navController (optional)
        composable("quote") {
            QuoteDetailScreen(viewModel = viewModel)
        }
    }
}
