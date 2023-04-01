package com.example.multi_game.ui.quizgame

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.multi_game.ui.theme.RedVelvet


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun QuizScreen(navController: NavHostController, gameViewModel: GameViewModel, onPlayAgain: () -> Unit, onExit: () -> Unit) {

    val uiState by gameViewModel.uiState.collectAsState()

    Scaffold(
        content = {
            Box(
                modifier = Modifier.fillMaxSize().padding(16.dp),

                ) {
                when (uiState.quizNumber) {
                    11 -> {
                        SummaryScreen(
                            navController = navController,
                            score = uiState.score,
                            onPlayAgain = onPlayAgain,
                            onExit = onExit
                        )
                    }
                    else -> {
                        QuestionScreen(
                            question = uiState.currentQuestion,
                            choices = uiState.choices,
                            score = uiState.score,
                            quizNum = uiState.quizNumber,
                            answer = uiState.currentQuestion.answer,
                            SelectedAnswer = gameViewModel::answerQuestion
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun QuestionScreen(question: Question, choices: List<String>, score: Int, quizNum: Int, answer: String, SelectedAnswer: (String) -> Unit) {

    Column(
        modifier = Modifier.padding(16.dp)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally

        ) {
        Text(
            text = "Quiz Game",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Italic,
            color = RedVelvet,
            textAlign = TextAlign.Center
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "$quizNum/10")
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End),
                text = "score: $score")
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = question.question,
            fontSize = 20.sp)

        Spacer(modifier = Modifier.height(16.dp))

        choices.forEach { choice ->
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                onClick = { SelectedAnswer(choice) },
                shape = RoundedCornerShape(5.dp),
                elevation = ButtonDefaults.elevation(5.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = RedVelvet,
                    contentColor = Color.White
                )
                ) {
                Text(text = choice,
                    fontSize = 18.sp)
            }
        }
    }
}

@Composable
fun SummaryScreen(navController: NavHostController, score: Int, onPlayAgain: () -> Unit, onExit: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Quiz Game",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Italic,
            color = RedVelvet,
            textAlign = TextAlign.Center,
        )
        Text(
            text = "Your score is $score out of 10",
            fontSize = 22.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onPlayAgain,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(5.dp),
            elevation = ButtonDefaults.elevation(5.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = RedVelvet,
                contentColor = Color.White
            ),
        ) {
            Text(text = "Play Again",
                fontSize = 22.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = onExit,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(5.dp),
            elevation = ButtonDefaults.elevation(5.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = RedVelvet,
                contentColor = Color.White
            ),
        ) {
            Text(text = "Exit",
                fontSize = 22.sp)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(),
            onClick = { navController.navigate("main_screen") },
            shape = RoundedCornerShape(5.dp),
            elevation = ButtonDefaults.elevation(5.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = RedVelvet,
                contentColor = Color.White
            )
        ){
            Text("Home",fontSize = 22.sp)
        }
    }
}
