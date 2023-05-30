package com.example.calculatorcompose.domain.model

data class CalculatorState(

    val firstNumber: String = "",
    val secondNumber: String = "",
    val operation: CalculatorOperation? = null

)
