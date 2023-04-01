package com.example.multi_game.ui

import android.graphics.fonts.FontFamily
import android.graphics.fonts.FontStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.multi_game.ui.theme.BG
import com.example.multi_game.ui.theme.RedVelvet
import com.example.multi_game.R


@Composable
fun MainScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BG)
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,

    ) {
        Text(
            text = "Multiple Games!",
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
            color = RedVelvet
        )
        Column(
            modifier = Modifier.padding(horizontal = 10.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.math),
                contentDescription = null,
                modifier = Modifier.size(120.dp)
                    .clickable(onClick = { navController.navigate("number_guessing_game_screen") }),
            )
            Button(
                onClick = { navController.navigate("number_guessing_game_screen") },
                content = { Text("Number Guessing Game", fontSize = 20.sp) },
                shape = RoundedCornerShape(5.dp),
                elevation = ButtonDefaults.elevation(5.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = RedVelvet,
                    contentColor = Color.White
                )
            )
        }
        Column(
            modifier = Modifier.padding(horizontal = 10.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.quiz),
                contentDescription = null,
                modifier = Modifier.size(120.dp)
                    .clickable(onClick = { navController.navigate("quiz_game_screen") }),
                )
            Button(
                onClick = { navController.navigate("quiz_game_screen") },
                content = { Text("Quiz Game", fontSize = 20.sp) },
                shape = RoundedCornerShape(5.dp),
                elevation = ButtonDefaults.elevation(5.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = RedVelvet,
                    contentColor = Color.White
                )
            )
        }
        Column(
            modifier = Modifier.padding(horizontal = 10.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.tic),
                contentDescription = null,
                modifier = Modifier.size(120.dp)
                    .clickable(onClick = { navController.navigate("tictactoe_game_screen") }),
                )
            Button(
                onClick = { navController.navigate("tictactoe_game_screen") },
                content = { Text("Tic-Tac-Toe", fontSize = 20.sp) },
                shape = RoundedCornerShape(5.dp),
                elevation = ButtonDefaults.elevation(5.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = RedVelvet,
                    contentColor = Color.White
                )
            )
        }

    }
}