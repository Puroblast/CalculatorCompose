package com.example.calculatorcompose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.calculatorcompose.domain.model.ButtonAction
import com.example.calculatorcompose.domain.model.CalculatorState
import com.example.calculatorcompose.domain.model.CalculatorOperation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CalculatorViewModel : ViewModel() {

    private val _state = MutableStateFlow(CalculatorState())
    val state = _state.asStateFlow()

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
        if (_state.value.firstNumber != "") {
            _state.value = _state.value.copy(operation = operation)
        }
    }

    private fun calculate() {
        if (_state.value.firstNumber != "" && _state.value.secondNumber != "" && _state.value.operation != null) {
            val firstNumber = _state.value.firstNumber.toDouble()
            val secondNumber = _state.value.secondNumber.toDouble()

            _state.value = when (_state.value.operation) {
                is CalculatorOperation.Divide -> {
                    _state.value.copy(
                        firstNumber = (firstNumber / secondNumber).toString().take(16)
                    )
                }

                is CalculatorOperation.Multiply -> {
                    _state.value.copy(
                        firstNumber = (firstNumber * secondNumber).toString().take(16)
                    )
                }

                is CalculatorOperation.Plus -> {
                    _state.value.copy(
                        firstNumber = (firstNumber + secondNumber).toString().take(16)
                    )
                }

                is CalculatorOperation.Minus -> {
                    _state.value.copy(
                        firstNumber = (firstNumber - secondNumber).toString().take(16)
                    )
                }

                else -> return
            }
            _state.value = _state.value.copy(secondNumber = "", operation = null)
        }
    }


    private fun putDecimal() {
        if (_state.value.firstNumber != "" && _state.value.operation == null && !_state.value.firstNumber.contains(".")
        ) {
            _state.value = _state.value.copy(firstNumber = _state.value.firstNumber + ".")
        } else if (_state.value.secondNumber != "" && _state.value.operation != null && !_state.value.secondNumber.contains(".")
        ) {
            _state.value = _state.value.copy(secondNumber = _state.value.secondNumber + ".")
        }
    }


    private fun clearField() {
        _state.value = CalculatorState()
    }

    private fun deleteNumber() {
        when {
            _state.value.secondNumber != "" -> _state.value =
                _state.value.copy(secondNumber = _state.value.secondNumber.dropLast(1))

            _state.value.operation != null -> _state.value = _state.value.copy(operation = null)
            _state.value.firstNumber != "" -> _state.value =
                _state.value.copy(firstNumber = _state.value.firstNumber.dropLast(1))
        }
    }

    private fun enterNumber(number: Int) {
        _state.value =
            if (_state.value.operation == null && _state.value.firstNumber.length < MAX_NUMBER_LENGTH) {
                _state.value.copy(firstNumber = _state.value.firstNumber + number)
            } else if (_state.value.operation != null && _state.value.secondNumber.length < MAX_NUMBER_LENGTH) {
                _state.value.copy(secondNumber = _state.value.secondNumber + number)
            } else {
                return
            }

    }

    companion object {
        private const val MAX_NUMBER_LENGTH = 8
    }


}