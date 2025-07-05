package com.example.tripquote.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tripquote.ui.theme.LightOrange
import com.example.tripquote.ui.theme.MediumOrange
import com.example.tripquote.ui.theme.DarkOrange

@Composable
fun LandingScreen(navController: NavController) {
    // Soft gradient background
    val backgroundGradient = Brush.verticalGradient(
        colors = listOf(
            LightOrange.copy(alpha = 0.8f),
            MediumOrange.copy(alpha = 0.5f),
            DarkOrange.copy(alpha = 0.3f)
        )
    )

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = backgroundGradient)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Triply Quotes",
                fontSize = 32.sp,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                shape = RoundedCornerShape(10.dp),
                onClick = { navController.navigate("quote") }) {
                Text("Get Sample Quote")
            }
        }
    }
}
