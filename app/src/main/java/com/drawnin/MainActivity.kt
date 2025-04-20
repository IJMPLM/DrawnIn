package com.drawnin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.drawnin.data.LessonData
import com.drawnin.ui.theme.DrawnInTheme
import com.drawnin.screens.CatalogScreen
import com.drawnin.screens.MainMenuScreen
import com.drawnin.screens.QuestionnaireScreen
import com.drawnin.screens.ResultSummaryScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrawnInTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "mainMenu"
    ) {
        composable("mainMenu") { MainMenuScreen(navController) }
        composable("catalog/{subject}") { backStackEntry ->
            val subject = backStackEntry.arguments?.getString("subject") ?: "Unknown"
            CatalogScreen(subject, navController)
        }
        composable("questionnaire/{subject}/{lessonName}") { backStackEntry ->
            val subject = backStackEntry.arguments?.getString("subject") ?: "Unknown"
            val lessonName = backStackEntry.arguments?.getString("lessonName") ?: "Unknown"
            val selectedLesson = when (subject) {
                "ARTS" -> LessonData.artsLessons.firstOrNull { it.name == lessonName }
                "MATH" -> LessonData.mathLessons.firstOrNull { it.name == lessonName }
                "MUSIC" -> LessonData.musicLessons.firstOrNull { it.name == lessonName }
                "SCIENCE" -> LessonData.scienceLessons.firstOrNull { it.name == lessonName }
                else -> null
            }
            if (selectedLesson != null) {
                QuestionnaireScreen(subject, lessonName, selectedLesson.questions, navController)

            }
        }
        composable("resultSummary/{subject}/{lessonName}/{userAnswers}") { backStackEntry ->
            val subject = backStackEntry.arguments?.getString("subject") ?: "Unknown"
            val lessonName = backStackEntry.arguments?.getString("lessonName") ?: "Unknown"
            val answersString = backStackEntry.arguments?.getString("userAnswers") ?: ""
            val userAnswers = answersString
                .split(",")
                .map { it.replace("%2C", ",") } // Or URLDecoder.decode(it, "UTF-8") if you use URLEncoder
            val selectedLesson = when (subject) {
                "ARTS" -> LessonData.artsLessons.firstOrNull { it.name == lessonName }
                "MATH" -> LessonData.mathLessons.firstOrNull { it.name == lessonName }
                "MUSIC" -> LessonData.musicLessons.firstOrNull { it.name == lessonName }
                "SCIENCE" -> LessonData.scienceLessons.firstOrNull { it.name == lessonName }
                else -> null
            }
            if (selectedLesson != null) {
                ResultSummaryScreen(selectedLesson.questions, userAnswers, navController)
            }
        }
    }
}

