package com.drawnin.data

import com.drawnin.R
import com.drawnin.data.sciencelessons.*

object ScienceLessons {
    val lessons = listOf(
        Lesson(
            "Minus",
            R.drawable.minus,
            questions = Weather.questions
        ),
        Lesson(
            "Add",
            R.drawable.add,
            questions = Things.questions
        ),
        Lesson(
            "Times",
            R.drawable.times,
            questions = Forces.questions
        )
    )
}
