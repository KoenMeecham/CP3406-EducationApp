package com.example.educationapp.views

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.educationapp.navigation.Screens

@Composable
fun FlashCardBottomNavBar(
    selectedRoute: String?,
    onHomeClicked: () -> Unit,
    onSettingsClicked: () -> Unit
) {
    NavigationBar {
        NavigationBarItem(
            selected = selectedRoute == Screens.Home.route,
            onClick = onHomeClicked,
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = selectedRoute == Screens.Settings.route,
            onClick = onSettingsClicked,
            icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
            label = { Text("Settings") }
        )
    }
}