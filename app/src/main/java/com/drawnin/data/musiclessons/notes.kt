package com.drawnin.data.musiclessons

import com.drawnin.data.Question

object Notes {
    val questions = listOf(
        Question(
            questionText = "What is a musical note?",
            options = listOf("A sound", "A color", "A shape", "A dance"),
            correctAnswerIndex = 0
        ),
        Question(
            questionText = "Which of these is a long sound?",
            options = listOf("Clap", "Drum hit", "Singing a word slowly", "Snap"),
            correctAnswerIndex = 2
        ),
        Question(
            questionText = "Which of these is a short sound?",
            options = listOf("Drum roll", "Singing", "Whistle", "Tap"),
            correctAnswerIndex = 3
        ),
        Question(
            questionText = "How many beats does a whole note have?",
            options = listOf("2", "1", "4", "3"),
            correctAnswerIndex = 2
        ),
        Question(
            questionText = "What is a fast beat called?",
            options = listOf("Slow", "Tempo", "Quick", "Fast beat"),
            correctAnswerIndex = 1
        ),
        Question(
            questionText = "What do we use to write music?",
            options = listOf("Notebook", "Music staff", "Book", "Canvas"),
            correctAnswerIndex = 1
        ),
        Question(
            questionText = "Which note is higher?",
            options = listOf("Low note", "Middle note", "High note", "Drum note"),
            correctAnswerIndex = 2
        ),
        Question(
            questionText = "Which note is lower?",
            options = listOf("High note", "Low note", "Sharp note", "Flat note"),
            correctAnswerIndex = 1
        ),
        Question(
            questionText = "What tells us how fast or slow to play?",
            options = listOf("Tempo", "Color", "Size", "Time"),
            correctAnswerIndex = 0
        ),
        Question(
            questionText = "What do we clap to follow rhythm?",
            options = listOf("Steps", "Beats", "Colors", "Tones"),
            correctAnswerIndex = 1
        )
    )
}
