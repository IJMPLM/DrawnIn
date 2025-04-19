package com.drawnin.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.drawnin.data.Question

@Composable
fun QuestionnaireScreen(questions: List<Question>, navController: NavHostController) {
    var currentQuestionIndex by remember { mutableStateOf(0) }

    if (currentQuestionIndex < questions.size) {
        val currentQuestion = questions[currentQuestionIndex]

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = currentQuestion.questionText, modifier = Modifier.padding(16.dp))
            Spacer(modifier = Modifier.height(16.dp))

            currentQuestion.options.forEachIndexed { index, option ->
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    onClick = {
                        // Check if the answer is correct
                        if (index == currentQuestion.correctAnswerIndex) {
                            currentQuestionIndex++
                        } else {
                            // Handle wrong answer (e.g., show feedback or stay on the question)
                        }
                    }
                ) {
                    Text(text = option)
                }
            }
        }
    } else {
        // When all questions are answered, navigate back or show a completion screen
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Congratulations! You've completed the questionnaire.")
            Button(onClick = { navController.popBackStack() }) {
                Text(text = "Return to Catalog")
            }
        }
    }
}
