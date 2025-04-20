package com.drawnin.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.drawnin.data.Lesson
import com.drawnin.data.LessonData
import com.drawnin.R

@Composable
fun CatalogScreen(subject: String, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.secondary)) // Fixed background color
            .padding(16.dp)
    ) {
        // Back button and subject title
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier.clickable { navController.popBackStack() },
                verticalAlignment = Alignment.CenterVertically
            ) {
                androidx.compose.material3.Icon(
                    painter = painterResource(id = R.drawable.back), // Replace with your back icon resource
                    tint = colorResource(id = R.color.white),
                    contentDescription = "Back",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                androidx.compose.material3.Text(
                    text = "Back",
                    color = colorResource(id = R.color.white),
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            androidx.compose.material3.Text(
                text = "$subject lessons", // Updated subject text
                fontSize = 30.sp,
                color = colorResource(id = R.color.primary),
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )
        }

        // Lesson grid
        val lessons = when (subject) {
            "ARTS" -> LessonData.artsLessons
            "MATH" -> LessonData.mathLessons
            "MUSIC" -> LessonData.musicLessons
            "SCIENCE" -> LessonData.scienceLessons
            else -> emptyList()
        }

        LessonGrid(subject, lessons, navController)
    }
}

@Composable
fun LessonGrid(
    subject: String,
    lessons: List<Lesson>,
    navController: NavHostController
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(lessons.size) { index ->
            val lesson = lessons[index]
            LessonItem(lesson = lesson, onClick = {
                navController.navigate("questionnaire/${subject}/${lesson.name}") // Pass the subject and lesson name
            })
        }
    }
}

@Composable
fun LessonItem(lesson: Lesson, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        androidx.compose.foundation.Image(
            painter = painterResource(id = lesson.imageResId),
            contentDescription = lesson.name,
            modifier = Modifier
                .size(100.dp)
                .padding(12.dp)
        )
        androidx.compose.material3.Text(
            text = lesson.name,
            fontSize = 25.sp,
            color = colorResource(id = R.color.accent)
        )
    }
}

