package com.example.multi_game.ui.quizgame

import com.example.multi_game.ui.quizgame.Question

data class GameUiState(
    val currentQuestion: Question,
    val choices: List<String>,
    val score: Int,
    val quizNumber: Int
)
