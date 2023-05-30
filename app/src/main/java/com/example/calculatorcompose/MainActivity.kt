package com.example.calculatorcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.calculatorcompose.presentation.ui.screens.Calculator
import com.example.calculatorcompose.presentation.viewmodel.CalculatorViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = CalculatorViewModel()
            Calculator(modifier = Modifier.fillMaxSize(), viewModel = viewModel)
        }
    }
}
