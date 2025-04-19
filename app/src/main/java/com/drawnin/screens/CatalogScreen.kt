package com.drawnin.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.drawnin.data.Lesson
import com.drawnin.data.LessonData

@Composable
fun CatalogScreen(subject: String, navController: NavHostController) {
    val lessons = when (subject) {
        "ARTS" -> LessonData.artsLessons
        "MATH" -> LessonData.mathLessons
        "MUSIC" -> LessonData.englishLessons
        "SCIENCE" -> LessonData.filipinoLessons
        else -> emptyList()
    }

    LessonGrid(lessons, navController)
}

@Composable
fun LessonGrid(lessons: List<Lesson>, navController: NavHostController) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(lessons.size) { index ->
            val lesson = lessons[index]
            LessonItem(lesson = lesson, onClick = { navController.navigate("questionnaire/${lesson.name}") })
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
                .padding(8.dp)
        )
        androidx.compose.material3.Text(text = lesson.name, fontSize = 16.sp)
    }
}

