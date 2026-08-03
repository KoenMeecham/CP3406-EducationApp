package com.example.educationapp.views

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ResultsReviewScreen(
    onBackClicked: () -> Unit
) {
    Scaffold(
        topBar = { FlashCardTopBar(title = "Results and Review", onBackClicked = onBackClicked) }
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Score Summary")
        }
    }
}