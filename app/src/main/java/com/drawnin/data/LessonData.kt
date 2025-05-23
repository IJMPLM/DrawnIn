package com.drawnin.data

import com.drawnin.R
import com.drawnin.data.artlessons.Crafts
import com.drawnin.data.artlessons.Shapes
import com.drawnin.data.artlessons.Textures
import com.drawnin.data.mathlessons.Add
import com.drawnin.data.mathlessons.Minus
import com.drawnin.data.mathlessons.Times
import com.drawnin.data.musiclessons.Instruments
import com.drawnin.data.musiclessons.Notes
import com.drawnin.data.musiclessons.Vocals
import com.drawnin.data.sciencelessons.Forces
import com.drawnin.data.sciencelessons.Things
import com.drawnin.data.sciencelessons.Weather

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
    val artsLessons = listOf(
        Lesson(
            "Textures",
            R.drawable.textures,
            questions = Textures.questions
        ),
        Lesson(
            "Shapes",
            R.drawable.shapes,
            questions = Shapes.questions
        ),
        Lesson(
            "Crafts",
            R.drawable.handcraft,
            questions = Crafts.questions
        )
    )
    val mathLessons = listOf(
        Lesson(
            "Minus",
            R.drawable.minus,
            questions = Minus.questions
        ),
        Lesson(
            "Add",
            R.drawable.add,
            questions = Add.questions
        ),
        Lesson(
            "Times",
            R.drawable.times,
            questions = Times.questions
        )
    )
    val musicLessons = listOf(
        Lesson(
            "Notes",
            R.drawable.notes,
            questions = Notes.questions
        ),
        Lesson(
            "Instruments",
            R.drawable.instruments,
            questions = Instruments.questions
        ),
        Lesson(
            "Vocals",
            R.drawable.vocals,
            questions = Vocals.questions
        )
    )
    val scienceLessons = listOf(
        Lesson(
            "Weather",
            R.drawable.weather,
            questions = Weather.questions
        ),
        Lesson(
            "Things",
            R.drawable.things,
            questions = Things.questions
        ),
        Lesson(
            "Forces",
            R.drawable.forces,
            questions = Forces.questions
        )
    )
}