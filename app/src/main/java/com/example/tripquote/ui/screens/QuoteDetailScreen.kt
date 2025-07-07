package com.example.tripquote.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.tripquote.ui.viewmodel.QuoteViewModel

@Composable
fun QuoteDetailScreen(viewModel: QuoteViewModel) {
    val quote by viewModel.quote.collectAsState(initial = null)
    val isLoading by viewModel.isLoading.collectAsState(initial = true)

    LaunchedEffect(Unit) {
        viewModel.getQuote()
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues()),
           // .padding(16.dp),
        color = MaterialTheme.colorScheme.background
    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Trip Quote",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
            quote?.let {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth(),
                    //colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(quote!!.imageUrl),
                            contentDescription = "Beach",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )

                        Row {
                            Text(
                                text = "Destination: ",
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                text = quote!!.destination,
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                        // 🗓️ Date + Travellers
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.CalendarToday,
                                    contentDescription = "Date",
                                    modifier = Modifier.size(18.dp),
                                    tint = Color.Gray
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = quote!!.travelDate,fontSize = 14.sp,
                                    color = Color.Gray
                                )
                            }

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Groups,
                                    contentDescription = "Travellers",
                                    modifier = Modifier.size(18.dp),
                                    tint = Color.Gray
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "${quote!!.travellers.toString()} travellers",
                                    fontSize = 14.sp,
                                    color = Color.Gray
                                )
                            }
                        }
                        Row {
                            Text(
                                text = "Total Cost: ",
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                text = quote!!.totalCost,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                        Button(
                            onClick = { },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                        ) {
                            Text("Contact Agent")
                        }
                    }
                }
            } ?: Text("Failed to load quote data.", color = Color.Red)
        }
    }
}}