package com.example.multi_game.ui.tictactoe

data class TicState(
    val playerCircleCount: Int = 0,
    val playerCrossCount: Int = 0,
    val drawCount: Int = 0,
    val hintText: String = "Player '1' turn",
    val currentTurn: BoardCellValue = BoardCellValue.CIRLCE,
    val victoryType: VictoryType = VictoryType.NONE,
    val hasWon: Boolean = false
)

enum class BoardCellValue {
    CIRLCE,
    CROSS,
    NONE
}

enum class VictoryType {
    HORIZONTAL1,
    HORIZONTAL2,
    HORIZONTAL3,
    VERTICAL1,
    VERTICAL2,
    VERTICAL3,
    DIAGONAL1,
    DIAGONAL2,
    NONE
}