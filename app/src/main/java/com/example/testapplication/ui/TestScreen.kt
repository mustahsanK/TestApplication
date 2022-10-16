package com.example.testapplication.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TestScreen(modifier: Modifier = Modifier, testViewModel: TestViewModel) {
    val testUiState = TestUiState()
    var textFieldValue by remember { mutableStateOf("") }
    
    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = testUiState.message)
        Spacer(modifier = modifier.size(16.dp))
        TextField(
            value = textFieldValue,
            onValueChange = { newTextFieldValue ->
                textFieldValue = newTextFieldValue
            }
        )
        PostButton(modifier = modifier, onPostButtonClicked = { testViewModel.updateCurrentMessage(textFieldValue) })
        GetButton(modifier = modifier, onGetButtonClicked = { testViewModel.updateTestState() })
    }
}

@Composable
fun GetButton(
    modifier: Modifier,
    onGetButtonClicked: () -> Unit
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onGetButtonClicked
    ) {
        Text(text = "Get Message")
    }
}

@Composable
fun PostButton(
    modifier: Modifier,
    onPostButtonClicked: () -> Unit
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onPostButtonClicked
    ) {
        Text(text = "Post Message")
    }
}