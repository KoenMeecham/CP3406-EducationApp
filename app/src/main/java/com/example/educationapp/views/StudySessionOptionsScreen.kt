package com.example.educationapp.views

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StudySessionOptionsScreen(
    topic: String,
    onBackClicked: () -> Unit,
    onStartStudying: () -> Unit
) {
    Scaffold(
        topBar = { FlashCardTopBar(title = "Study Session Options", onBackClicked = onBackClicked) }
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp)
        ) {
            Text("Topic: $topic", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = onStartStudying) {
                Text("Start Studying")
            }
        }
    }
}