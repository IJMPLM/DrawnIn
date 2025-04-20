package com.drawnin.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.drawnin.data.Question
import kotlin.compareTo
import kotlin.inc
import kotlin.text.clear
import kotlin.text.toFloat

@Composable
fun QuestionnaireScreen(
    questions: List<Question>,
    navController: NavHostController
) {
    var currentQuestionIndex by remember { mutableStateOf(0) }
    val paths = remember { mutableStateListOf<Path>() }
    var currentPath by remember { mutableStateOf(Path()) }
    val userAnswers = remember { mutableStateListOf<String>() }

    if (currentQuestionIndex < questions.size) {
        val currentQuestion = questions[currentQuestionIndex]

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Scrollable content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = currentQuestion.questionText,
                    modifier = Modifier.padding(16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Display options
                currentQuestion.options.forEach { option ->
                    Button(
                        onClick = {
                            userAnswers.add(option)
                            currentQuestionIndex++
                            paths.clear() // Clear the canvas for the next question
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Text(text = option)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Fixed canvas position
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(Color.LightGray)
                    .border(2.dp, Color.Black)
                    .pointerInput(Unit) {
                        detectDragGestures(
                            onDragStart = { offset ->
                                if (offset.x in 0f..this.size.width.toFloat() && offset.y in 0f..this.size.height.toFloat()) {
                                    currentPath.moveTo(offset.x, offset.y)
                                }
                            },
                            onDrag = { change, _ ->
                                val constrainedX = change.position.x.coerceIn(0f, this.size.width.toFloat())
                                val constrainedY = change.position.y.coerceIn(0f, this.size.height.toFloat())
                                currentPath.lineTo(constrainedX, constrainedY)
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

            // Skip button
            Button(
                onClick = {
                    userAnswers.add("Skipped")
                    currentQuestionIndex++
                    paths.clear()
                }
            ) {
                Text(text = "Skip")
            }
        }
    } else {
        // Navigate to ResultSummaryScreen
        navController.navigate("resultSummary/${userAnswers.joinToString(",")}")
    }
}