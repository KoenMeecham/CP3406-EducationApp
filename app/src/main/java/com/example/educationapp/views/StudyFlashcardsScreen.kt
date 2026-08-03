package com.example.educationapp.views

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StudyFlashcardsScreen(
    topic: String,
    onBackClicked: () -> Unit,
    onFinishSession: () -> Unit
) {
    Scaffold(
        topBar = { FlashCardTopBar(title = "Studying: $topic", onBackClicked = onBackClicked) }
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Flashcard")
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = onFinishSession) {
                Text("Finish Session")
            }
        }
    }
}