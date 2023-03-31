package com.example.multi_game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.multi_game.ui.theme.MultiGameTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.multi_game.ui.MainScreen
import com.example.multi_game.ui.numberguessing.NumberGuessingGameScreen
import com.example.multi_game.ui.quizgame.GameViewModel
import com.example.multi_game.ui.quizgame.QuizScreen
import com.example.multi_game.ui.tictactoe.TicTacScreen
import com.example.multi_game.ui.tictactoe.TicViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gameViewModel: GameViewModel by viewModels()
        val viewModel: TicViewModel by viewModels()
        setContent {
            val navController = rememberNavController()
            MultiGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = "main_screen"
                    ) {
                        composable("main_screen") {
                            MainScreen(navController)
                        }
                        composable("quiz_game_screen") {
                            QuizScreen(navController ,
                                gameViewModel = gameViewModel,
                                onPlayAgain = gameViewModel::resetQuiz,
                                onExit = { finish() }
                            )
                        }
                        composable("number_guessing_game_screen") {
                            NumberGuessingGameScreen(navController)
                        }
                        composable("tictactoe_game_screen") {
                            TicTacScreen(navController, viewModel = viewModel)
                        }
                    }
                }
            }
        }
    }
}
