package com.example.educationapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.educationapp.views.*

@Composable
fun AppNavigation(navHostController: NavHostController = rememberNavController()) {
    val currentBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            FlashCardBottomNavBar(
                selectedRoute = currentRoute,
                onHomeClicked = {
                    navHostController.navigate(Screens.Home.route) {
                        popUpTo(Screens.Home.route) { inclusive = true }
                    }
                },
                onSettingsClicked = { navHostController.navigate(Screens.Settings.route) }
            )
        }
    ) { padding ->
        NavHost(
            navController = navHostController,
            startDestination = Screens.Home.route,
            modifier = androidx.compose.ui.Modifier.padding(padding)
        ) {
            composable(Screens.Home.route) {
                HomeScreen(onBeginStudySession = { navHostController.navigate(Screens.Topic.route) })
            }
            composable(Screens.Topic.route) {
                TopicScreen(
                    onBackClicked = navHostController::popBackStack,
                    onTopicSelected = { topic ->
                        navHostController.navigate("${Screens.StudySessionOptions.route}/$topic")
                    }
                )
            }
            composable("${Screens.StudySessionOptions.route}/{topic}") { backStackEntry ->
                val topic = backStackEntry.arguments?.getString("topic") ?: ""
                StudySessionOptionsScreen(
                    topic = topic,
                    onBackClicked = navHostController::popBackStack,
                    onStartStudying = {
                        navHostController.navigate("${Screens.StudyFlashcards.route}/$topic")
                    }
                )
            }
            composable("${Screens.StudyFlashcards.route}/{topic}") { backStackEntry ->
                val topic = backStackEntry.arguments?.getString("topic") ?: ""
                StudyFlashcardsScreen(
                    topic = topic,
                    onBackClicked = navHostController::popBackStack,
                    onFinishSession = { navHostController.navigate(Screens.ResultsReview.route) }
                )
            }
            composable(Screens.ResultsReview.route) {
                ResultsReviewScreen(onBackClicked = navHostController::popBackStack)
            }
            composable(Screens.Settings.route) {
                SettingsScreen()
            }
        }
    }
}