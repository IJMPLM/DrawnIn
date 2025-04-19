package com.drawnin.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.drawnin.data.LessonData
import com.drawnin.data.Question
import kotlin.compareTo
import kotlin.inc
import kotlin.text.clear
import kotlin.text.toFloat

@Composable
fun QuestionnaireScreen(questions: List<Question>, navController: NavHostController) {
    var currentQuestionIndex by remember { mutableStateOf(0) }
    val paths = remember { mutableStateListOf<Path>() }
    var currentPath by remember { mutableStateOf(Path()) }

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

            // Canvas for drawing with outline and background color
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(Color.LightGray) // Background color
                    .border(2.dp, Color.Black) // Outline
                    .pointerInput(Unit) {
                        detectDragGestures(
                            onDragStart = { offset ->
                                // Ensure the starting point is within bounds
                                if (offset.x in 0f..this.size.width.toFloat() && offset.y in 0f..this.size.height.toFloat()) {
                                    currentPath.moveTo(offset.x, offset.y)
                                }
                            },
                            onDrag = { change, _ ->
                                // Constrain the drag position to the bounds of the Canvas
                                val constrainedX = change.position.x.coerceIn(0f, this.size.width.toFloat())
                                val constrainedY = change.position.y.coerceIn(0f, this.size.height.toFloat())
                                currentPath.lineTo(constrainedX, constrainedY)

                                // Trigger recomposition to make the stroke immediately visible
                                currentPath = Path().apply {
                                    addPath(currentPath)
                                }
                            },
                            onDragEnd = {
                                paths.add(currentPath)
                                currentPath = Path()
                            }
                        )
                    }
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    clipRect {
                        paths.forEach { path ->
                            drawPath(
                                path = path,
                                color = Color.Black,
                                style = androidx.compose.ui.graphics.drawscope.Stroke(width = 16f)
                            )
                        }
                        drawPath(
                            path = currentPath,
                            color = Color.Black,
                            style = androidx.compose.ui.graphics.drawscope.Stroke(width = 16f)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Submit button
            Button(
                onClick = {
                    currentQuestionIndex++
                    paths.clear() // Clear the canvas for the next question
                }
            ) {
                Text(text = "Submit")
            }
        }
    } else {
        // Completion screen
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

@Preview(showBackground = true)
@Composable
fun PreviewQuestionnaireScreenWithCanvas() {
    val navController = rememberNavController() // Mock NavController for preview
    val lesson = LessonData.artsLessons.first { it.name == "Minus" } // Get the "Minus" lesson
    QuestionnaireScreen(questions = lesson.questions, navController = navController)
}