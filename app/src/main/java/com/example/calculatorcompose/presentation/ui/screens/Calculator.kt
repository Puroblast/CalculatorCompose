package com.example.calculatorcompose.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorcompose.domain.model.ButtonAction
import com.example.calculatorcompose.domain.model.CalculatorOperation
import com.example.calculatorcompose.domain.model.CalculatorState
import com.example.calculatorcompose.presentation.ui.buttons.CalculatorButton
import com.example.calculatorcompose.presentation.viewmodel.CalculatorViewModel

@Composable
fun Calculator(

    modifier: Modifier,
    viewModel: CalculatorViewModel,
    state: CalculatorState

) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text = if (state.operation == null || state.secondNumber == "") state.firstNumber
                else state.secondNumber,
                fontSize = 80.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.End)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                CalculatorButton(
                    text = "AC",
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f)
                ) {
                    viewModel.onAction(ButtonAction.Clear)
                }
                CalculatorButton(
                    text = "Del",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(ButtonAction.Delete)
                }
                CalculatorButton(
                    text = "/", modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(ButtonAction.Operation(CalculatorOperation.Divide))
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                CalculatorButton(
                    text = "7",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(ButtonAction.Number(7))
                }
                CalculatorButton(
                    text = "8",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(ButtonAction.Number(8))
                }
                CalculatorButton(
                    text = "9",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(ButtonAction.Number(9))
                }
                CalculatorButton(
                    text = "X",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(ButtonAction.Operation(CalculatorOperation.Multiply))
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                CalculatorButton(
                    text = "4",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(ButtonAction.Number(4))
                }
                CalculatorButton(
                    text = "5",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(ButtonAction.Number(5))
                }
                CalculatorButton(
                    text = "6",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(ButtonAction.Number(6))
                }
                CalculatorButton(
                    text = "-",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(ButtonAction.Operation(CalculatorOperation.Minus))
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                CalculatorButton(
                    text = "1",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(ButtonAction.Number(1))
                }
                CalculatorButton(
                    text = "2",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(ButtonAction.Number(2))
                }
                CalculatorButton(
                    text = "3",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(ButtonAction.Number(3))
                }
                CalculatorButton(
                    text = "+",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(ButtonAction.Operation(CalculatorOperation.Plus))
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                CalculatorButton(
                    text = "0",
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f)
                ) {
                    viewModel.onAction(ButtonAction.Number(0))
                }
                CalculatorButton(
                    text = ".",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(ButtonAction.Decimal)
                }
                CalculatorButton(
                    text = "=",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(ButtonAction.Equal)
                }
            }
        }
    }
}