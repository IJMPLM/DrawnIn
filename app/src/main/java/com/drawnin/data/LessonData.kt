package com.drawnin.data

import com.drawnin.R

data class Question(
    val questionText: String,
    val options: List<String>, // Multiple-choice options
    val correctAnswerIndex: Int // Index of the correct answer
)
data class Lesson(
    val name: String,
    val imageResId: Int,
    val questions: List<Question> // List of questions for the lesson
)

object LessonData {
    val artsLessons = ArtLessons.lessons
    val mathLessons = MathLessons.lessons
    val englishLessons = MusicLessons.lessons
    val filipinoLessons = ScienceLessons.lessons
}