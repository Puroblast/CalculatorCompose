package com.example.calculatorcompose.domain.model

sealed class ButtonAction {

    data class Number(val number: Int) : ButtonAction()
    object Delete : ButtonAction()
    object Clear : ButtonAction()
    object Decimal : ButtonAction()
    object Equal : ButtonAction()
    data class Operation(val operation: CalculatorOperation) : ButtonAction()

}
