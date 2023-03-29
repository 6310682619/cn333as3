package com.example.multi_game.ui.quizgame

import androidx.lifecycle.ViewModel
import com.example.multi_game.ui.quizgame.Question
import com.example.multi_game.ui.quizgame.QuizData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel : ViewModel() {

    private val quizData = QuizData()
    private var questions = quizData.questions.shuffled()
    private var quizNumber = 0
    private var score = 0

    private val _uiState = MutableStateFlow(GameUiState(
        currentQuestion = questions[quizNumber],
        choices = questions[quizNumber].choices.shuffled(),
        score = score,
        quizNumber = quizNumber + 1
    ))

    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    fun answerQuestion(answer: String) {
        if (answer == questions[quizNumber].answer) {
            score++
        }

        quizNumber++

        if (quizNumber < 11) {
            _uiState.value = GameUiState(
                currentQuestion = questions[quizNumber],
                choices = questions[quizNumber].choices.shuffled(),
                score = score,
                quizNumber = quizNumber + 1
            )
        } else {
            _uiState.value = GameUiState(
                currentQuestion = Question("", "", listOf()),
                choices = listOf(),
                score = score,
                quizNumber = quizNumber
            )
        }
    }

    fun resetQuiz() {
        questions = quizData.questions.shuffled()
        quizNumber = 0
        score = 0

        _uiState.value = GameUiState(
            currentQuestion = questions[quizNumber],
            choices = questions[quizNumber].choices.shuffled(),
            score = score,
            quizNumber = quizNumber + 1
        )
    }
}
