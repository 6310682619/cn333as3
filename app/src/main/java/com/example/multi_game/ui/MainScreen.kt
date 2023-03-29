package com.example.multi_game.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun MainScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Button(
            onClick = { navController.navigate("number_guessing_game_screen") },
            content = { Text("Number Guessing Game") }
        )
        Button(
            onClick = { navController.navigate("quiz_game_screen") },
            content = { Text("Quiz Game") }
        )
    }
}