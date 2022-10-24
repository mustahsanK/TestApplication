package com.example.testapplication.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TestViewModel: ViewModel() {
    private var _uiState = MutableStateFlow(TestUiState())
    val uiState: StateFlow<TestUiState> = _uiState.asStateFlow()

    var currentMessage: String = ""

    fun updateCurrentMessage(entered: String) {
        currentMessage = entered
    }

    fun updateTestState() {
        _uiState.update { currentState ->
            currentState.copy(
                message = currentMessage
            )
        }
    }
}