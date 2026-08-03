package com.example.educationapp.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
private val sampleTopics = listOf("Geography", "Science", "History", "Movies")

@Composable
fun TopicScreen(
    onBackClicked: () -> Unit,
    onTopicSelected: (String) -> Unit
) {
    Scaffold(
        topBar = { FlashCardTopBar(title = "Choose a Topic", onBackClicked = onBackClicked) }
    ) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp)) {
            sampleTopics.forEach { topic ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .clickable { onTopicSelected(topic) }
                ) {
                    Text(text = topic, modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}