package com.drawnin.data

import com.drawnin.R
import com.drawnin.data.musiclessons.*

object MusicLessons {
    val lessons = listOf(
        Lesson(
            "Minus",
            R.drawable.minus,
            questions = Notes.questions
        ),
        Lesson(
            "Add",
            R.drawable.add,
            questions = Instruments.questions
        ),
        Lesson(
            "Times",
            R.drawable.times,
            questions = Vocals.questions
        )
    )
}
