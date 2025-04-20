package com.drawnin.data

import com.drawnin.R
import com.drawnin.data.artlessons.*

object ArtLessons {
    val lessons = listOf(
        Lesson(
            "Minus",
            R.drawable.minus,
            questions = Textures.questions
        ),
        Lesson(
            "Add",
            R.drawable.add,
            questions = Shapes.questions
        ),
        Lesson(
            "Times",
            R.drawable.times,
            questions = Crafts.questions
        )
    )
}
