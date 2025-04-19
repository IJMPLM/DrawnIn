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
    val artsLessons = listOf(
        Lesson(
            "Minus",
            R.drawable.minus,
            questions = listOf(
                Question(
                    questionText = "What is the primary medium used in oil painting?",
                    options = listOf("Oil", "Water", "Acrylic", "Ink"),
                    correctAnswerIndex = 0
                ),
                Question(
                    questionText = "Who painted the Mona Lisa?",
                    options = listOf("Van Gogh", "Leonardo da Vinci", "Picasso", "Michelangelo"),
                    correctAnswerIndex = 1
                )
            )
        ),
        Lesson(
            "Add",
            R.drawable.add,
            questions = listOf(
                Question(
                    questionText = "What is the primary medium used in oil painting?",
                    options = listOf("Oil", "Water", "Acrylic", "Ink"),
                    correctAnswerIndex = 0
                ),
                Question(
                    questionText = "Who painted the Mona Lisa?",
                    options = listOf("Van Gogh", "Leonardo da Vinci", "Picasso", "Michelangelo"),
                    correctAnswerIndex = 1
                )
            )
        ),
        Lesson(
            "Times",
            R.drawable.times,
            questions = listOf(
                Question(
                    questionText = "What is the primary medium used in oil painting?",
                    options = listOf("Oil", "Water", "Acrylic", "Ink"),
                    correctAnswerIndex = 0
                ),
                Question(
                    questionText = "Who painted the Mona Lisa?",
                    options = listOf("Van Gogh", "Leonardo da Vinci", "Picasso", "Michelangelo"),
                    correctAnswerIndex = 1
                )
            )
        )
    )
    val mathLessons = listOf(
        Lesson(
            "Minus",
            R.drawable.minus,
            questions = listOf(
                Question(
                    questionText = "What is the sum of angles in a triangle?",
                    options = listOf("180 degrees", "90 degrees", "360 degrees", "45 degrees"),
                    correctAnswerIndex = 0
                ),
                Question(
                    questionText = "What is a shape with four equal sides called?",
                    options = listOf("Rectangle", "Rhombus", "Square", "Parallelogram"),
                    correctAnswerIndex = 2
                )
            )
        ),
        Lesson(
            "Add",
            R.drawable.add,
            questions = listOf(
                Question(
                    questionText = "What is the sum of angles in a triangle?",
                    options = listOf("180 degrees", "90 degrees", "360 degrees", "45 degrees"),
                    correctAnswerIndex = 0
                ),
                Question(
                    questionText = "What is a shape with four equal sides called?",
                    options = listOf("Rectangle", "Rhombus", "Square", "Parallelogram"),
                    correctAnswerIndex = 2
                )
            )
        ),
        Lesson(
            "Times",
            R.drawable.times,
            questions = listOf(
                Question(
                    questionText = "What is the sum of angles in a triangle?",
                    options = listOf("180 degrees", "90 degrees", "360 degrees", "45 degrees"),
                    correctAnswerIndex = 0
                ),
                Question(
                    questionText = "What is a shape with four equal sides called?",
                    options = listOf("Rectangle", "Rhombus", "Square", "Parallelogram"),
                    correctAnswerIndex = 2
                )
            )
        )
    )
    val englishLessons = listOf(
        Lesson(
            "Minus",
            R.drawable.minus,
            questions = listOf(
                Question(
                    questionText = "What is the sum of angles in a triangle?",
                    options = listOf("180 degrees", "90 degrees", "360 degrees", "45 degrees"),
                    correctAnswerIndex = 0
                ),
                Question(
                    questionText = "What is a shape with four equal sides called?",
                    options = listOf("Rectangle", "Rhombus", "Square", "Parallelogram"),
                    correctAnswerIndex = 2
                )
            )
        ),
        Lesson(
            "Add",
            R.drawable.add,
            questions = listOf(
                Question(
                    questionText = "What is the sum of angles in a triangle?",
                    options = listOf("180 degrees", "90 degrees", "360 degrees", "45 degrees"),
                    correctAnswerIndex = 0
                ),
                Question(
                    questionText = "What is a shape with four equal sides called?",
                    options = listOf("Rectangle", "Rhombus", "Square", "Parallelogram"),
                    correctAnswerIndex = 2
                )
            )
        ),
        Lesson(
            "Times",
            R.drawable.times,
            questions = listOf(
                Question(
                    questionText = "What is the sum of angles in a triangle?",
                    options = listOf("180 degrees", "90 degrees", "360 degrees", "45 degrees"),
                    correctAnswerIndex = 0
                ),
                Question(
                    questionText = "What is a shape with four equal sides called?",
                    options = listOf("Rectangle", "Rhombus", "Square", "Parallelogram"),
                    correctAnswerIndex = 2
                )
            )
        )
    )
    val filipinoLessons = listOf(
        Lesson(
            "Minus",
            R.drawable.minus,
            questions = listOf(
                Question(
                    questionText = "What is the sum of angles in a triangle?",
                    options = listOf("180 degrees", "90 degrees", "360 degrees", "45 degrees"),
                    correctAnswerIndex = 0
                ),
                Question(
                    questionText = "What is a shape with four equal sides called?",
                    options = listOf("Rectangle", "Rhombus", "Square", "Parallelogram"),
                    correctAnswerIndex = 2
                )
            )
        ),
        Lesson(
            "Add",
            R.drawable.add,
            questions = listOf(
                Question(
                    questionText = "What is the sum of angles in a triangle?",
                    options = listOf("180 degrees", "90 degrees", "360 degrees", "45 degrees"),
                    correctAnswerIndex = 0
                ),
                Question(
                    questionText = "What is a shape with four equal sides called?",
                    options = listOf("Rectangle", "Rhombus", "Square", "Parallelogram"),
                    correctAnswerIndex = 2
                )
            )
        ),
        Lesson(
            "Times",
            R.drawable.times,
            questions = listOf(
                Question(
                    questionText = "What is the sum of angles in a triangle?",
                    options = listOf("180 degrees", "90 degrees", "360 degrees", "45 degrees"),
                    correctAnswerIndex = 0
                ),
                Question(
                    questionText = "What is a shape with four equal sides called?",
                    options = listOf("Rectangle", "Rhombus", "Square", "Parallelogram"),
                    correctAnswerIndex = 2
                )
            )
        )
    )
}