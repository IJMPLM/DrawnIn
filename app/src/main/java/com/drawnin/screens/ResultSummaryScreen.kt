package com.drawnin.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.drawnin.data.Question
import kotlin.text.get

@Composable
fun ResultSummaryScreen(
    questions: List<Question>,
    userAnswers: List<String>,
    navController: NavHostController
) {
    val totalScore = questions.zip(userAnswers).count { (question, answer) ->
        question.options[question.correctAnswerIndex] == answer
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = androidx.compose.ui.graphics.Color.White) // Solid background
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Result Summary", modifier = Modifier.padding(16.dp))

        questions.zip(userAnswers).forEachIndexed { index, (question, answer) ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Q${index + 1}: ${question.questionText}")
                Text(text = "Your Answer: $answer")
                Text(text = "Correct Answer: ${question.options[question.correctAnswerIndex]}")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Total Score: $totalScore / ${questions.size}")

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("mainMenu") }, // Navigate to main menu
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Back to Main Menu")
        }
    }
}