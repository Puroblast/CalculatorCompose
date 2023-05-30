package com.example.calculatorcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.calculatorcompose.presentation.ui.screens.Calculator
import com.example.calculatorcompose.presentation.viewmodel.CalculatorViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: CalculatorViewModel by viewModels()
            val calculatorState by viewModel.state.collectAsState()
            Calculator(modifier = Modifier.fillMaxSize(), viewModel = viewModel, state = calculatorState)
        }
    }
}
