package com.drawnin.data

import com.drawnin.R
import com.drawnin.data.mathlessons.*

object MathLessons {
    val lessons = listOf(
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
}
