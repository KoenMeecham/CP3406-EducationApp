package com.example.educationapp.navigation

sealed class Screens(val route: String) {
    object Home : Screens("home")
    object Topic : Screens("topic")
    object StudySessionOptions : Screens("studyOptions")
    object StudyFlashcards : Screens("studyFlashcards")
    object ResultsReview : Screens("resultsReview")
    object Settings : Screens("settings")
}