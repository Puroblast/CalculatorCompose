package com.example.calculatorcompose.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.calculatorcompose.domain.model.ButtonAction
import com.example.calculatorcompose.domain.model.CalculatorState
import com.example.calculatorcompose.domain.model.CalculatorOperation

class CalculatorViewModel : ViewModel() {

    var state by mutableStateOf(CalculatorState())

    fun onAction(action: ButtonAction) {
        when (action) {
            is ButtonAction.Number -> enterNumber(action.number)
            is ButtonAction.Delete -> deleteNumber()
            is ButtonAction.Clear -> clearField()
            is ButtonAction.Operation -> createOperation(action.operation)
            is ButtonAction.Decimal -> putDecimal()
            is ButtonAction.Equal -> calculate()

        }
    }

    private fun createOperation(operation: CalculatorOperation) {
        if (state.firstNumber != "") {
            state = state.copy(operation = operation)
        }
    }

    private fun calculate() {
        if (state.firstNumber != "" && state.secondNumber != "" && state.operation != null) {
            val firstNumber = state.firstNumber.toDouble()
            val secondNumber = state.secondNumber.toDouble()

            state = when (state.operation) {
                is CalculatorOperation.Divide -> {
                    state.copy(firstNumber = (firstNumber / secondNumber).toString().take(16))
                }

                is CalculatorOperation.Multiply -> {
                    state.copy(firstNumber = (firstNumber * secondNumber).toString().take(16))
                }

                is CalculatorOperation.Plus -> {
                    state.copy(firstNumber = (firstNumber + secondNumber).toString().take(16))
                }

                is CalculatorOperation.Minus -> {
                    state.copy(firstNumber = (firstNumber - secondNumber).toString().take(16))
                }

                else -> return
            }
            state = state.copy(secondNumber = "")
            state = state.copy(operation = null)
        }
    }


    private fun putDecimal() {
        if (state.firstNumber != "" && state.operation == null && !state.firstNumber.contains(".")) {
            state = state.copy(firstNumber = state.firstNumber + ".")
        } else if (state.secondNumber != "" && state.operation != null && !state.secondNumber.contains(
                "."
            )
        ) {
            state = state.copy(secondNumber = state.secondNumber + ".")
        }
    }


    private fun clearField() {
        state = CalculatorState()
    }

    private fun deleteNumber() {
        when {
            state.secondNumber != "" -> state =
                state.copy(secondNumber = state.secondNumber.dropLast(1))

            state.operation != null -> state = state.copy(operation = null)
            state.firstNumber != "" -> state =
                state.copy(firstNumber = state.firstNumber.dropLast(1))
        }
    }

    private fun enterNumber(number: Int) {
        state = if (state.operation == null && state.firstNumber.length < MAX_NUMBER_LENGTH) {
            state.copy(firstNumber = state.firstNumber + number)
        } else if (state.operation != null && state.secondNumber.length < MAX_NUMBER_LENGTH) {
            state.copy(secondNumber = state.secondNumber + number)
        } else {
            return
        }

    }

    companion object {
        private const val MAX_NUMBER_LENGTH = 8
    }


}