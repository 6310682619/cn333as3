package com.example.multi_game.ui.numberguessing

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.multi_game.ui.theme.RedVelvet

var numTries : Int = 0
private fun guessNumber(input: Int, random: Int): String {
    numTries++
    if(input < random) {
        return if ((random - input) < 10){
            "So close! Your number is too low."
        }else{
            "Your number is too low."
        }
    } else if (input > random) {
        return if ((input - random) < 10){
            "So close! Your number is too high."
        }else{
            "Your number is too high."
        }
    }
    return "Congratulations!\nYou found the number in $numTries attempts."
}

@Composable
fun NumberGuessingGameScreen(navController: NavHostController) {
    var random by remember { mutableStateOf((1..1000).random()) }
    var getNumber by remember { mutableStateOf("") }
    val input = getNumber.toIntOrNull()
    var hint by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Text(
            text = "Number Guessing Game",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Italic,
            color = RedVelvet,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = "Try to guess the number from 1 - 1,000!",
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(100.dp))
        EditNumberField(
            value = getNumber,
            onValueChange = { getNumber = it }
        )
        Text(
            text = hint,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(16.dp))
        Row() {
            Button(
                shape = RoundedCornerShape(5.dp),
                elevation = ButtonDefaults.elevation(5.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = RedVelvet,
                    contentColor = Color.White
                ),
                onClick = {
                    if (input != null) {
                        hint = guessNumber(input, random)
                    }
                }) {
                Text(
                    text = "Enter",
                    fontSize = 24.sp)
            }
            Spacer(Modifier.width(20.dp))
            Button(
                shape = RoundedCornerShape(5.dp),
                elevation = ButtonDefaults.elevation(5.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = RedVelvet,
                    contentColor = Color.White
                ),
                onClick = {
                    random = (1..1000).random()
                    getNumber = ""
                    numTries = 0
                    hint = ""
                }) {
                Text(
                    text = "Play Again",
                    fontSize = 24.sp)
            }
        }

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            onClick = { navController.navigate("main_screen") },
            shape = RoundedCornerShape(5.dp),
            elevation = ButtonDefaults.elevation(5.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = RedVelvet,
                contentColor = Color.White
            ),
            content = { Text("Home",fontSize = 24.sp) }
        )
    }
}

@Composable
fun EditNumberField(
    value: String,
    onValueChange: (String) -> Unit
) {
    val focusManager = LocalFocusManager.current
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = "Enter Number") },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done),
    )
}
