package com.example.multi_game.ui.quizgame

data class Question(
    val question: String,
    val answer: String,
    val choices: List<String>
)

class QuizData {

    val questions = listOf(
        Question(
            question = "What is the capital of France?",
            answer = "Paris",
            choices = listOf("Paris", "London", "Berlin", "Madrid")
        ),
        Question(
            question = "What is the largest planet in our solar system?",
            answer = "Jupiter",
            choices = listOf("Jupiter", "Mars", "Venus", "Saturn")
        ),
        Question(
            question = "What is the chemical symbol for gold?",
            answer = "Au",
            choices = listOf("Au", "Ag", "Cu", "Fe")
        ),
        Question(
            question = "What is the largest continent in the world?",
            answer = "Asia",
            choices = listOf("Asia", "Africa", "North America", "Europe")
        ),
        Question(
            question = "What is the smallest country in the world by land area?",
            answer = "Monaco",
            choices = listOf("Monaco", "San Marino", "Vatican City", "Liechtenstein")
        ),
        Question(
            question = "Who is the creator of the Harry Potter series?",
            answer = "J.K. Rowling",
            choices = listOf("J.K. Rowling", "Stephenie Meyer", "Suzanne Collins", "George R.R. Martin")
        ),
        Question(
            question = "Which river runs through Egypt?",
            answer = "Nile",
            choices = listOf("Nile", "Amazon", "Yangtze", "Mississippi")
        ),
        Question(
            question = "What is the largest country in South America by land area?",
            answer = "Brazil",
            choices = listOf("Brazil", "Argentina", "Colombia", "Peru")
        ),
        Question(
            question = "Who plays the role of Loki in the Marvel Cinematic Universe?",
            answer = "Tom Hiddleston",
            choices = listOf("Tom Hardy", "Tom Hiddleston", "Chris Hemsworth", "Robert Downey Jr.")
        ),
        Question(
            question = "What is the national animal of Thailand?",
            answer = "Elephant",
            choices = listOf("Elephant", "Tiger", "Dog", "Lion")
        ),
        Question(
            question = "Who is Loki in Norse mythology?",
            answer = "The god of mischief",
            choices = listOf("The god of thunder", "The god of love", "The god of mischief", "The god of wisdom")
        )
    )
}