package com.example.calculatorcompose.domain.model


sealed class CalculatorOperation(val symbol: String) {

    object Plus : CalculatorOperation("+")
    object Minus : CalculatorOperation("-")
    object Multiply : CalculatorOperation("*")
    object Divide : CalculatorOperation("/")

}
