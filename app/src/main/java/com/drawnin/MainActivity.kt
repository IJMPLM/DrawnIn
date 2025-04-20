package com.drawnin

import android.content.Intent
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
        composable("questionnaire/{lessonName}") { backStackEntry ->
            val lessonName = backStackEntry.arguments?.getString("lessonName") ?: "Unknown"
            val lesson = LessonData.artsLessons.firstOrNull { it.name == lessonName }
            if (lesson != null) {
                QuestionnaireScreen(lesson.questions, navController)
            }
        }
        composable("resultSummary/{userAnswers}") { backStackEntry ->
            val userAnswers = backStackEntry.arguments?.getString("userAnswers")?.split(",") ?: emptyList()
            val lesson = LessonData.artsLessons.firstOrNull { it.name == "Minus" } // Adjust as needed
            if (lesson != null) {
                ResultSummaryScreen(lesson.questions, userAnswers, navController)
            }
        }
    }
}

