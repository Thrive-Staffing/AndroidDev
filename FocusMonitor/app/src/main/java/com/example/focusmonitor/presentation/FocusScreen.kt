package com.example.focusmonitor.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.focusmonitor.presentation.vm.FocusScoreViewModel

@Composable
fun FocusScreen(
    viewModel: FocusScoreViewModel = hiltViewModel(),
    modifier: Modifier
) {
    val focusScore by viewModel.focusScore.collectAsState()
    var isMonitoring by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Focus Score: $focusScore", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            isMonitoring = !isMonitoring
            if (isMonitoring) {
                viewModel.startMonitoring()
            } else {
                viewModel.stopMonitoring()
            }
        }) {
            Text(text = if (isMonitoring) "Stop Monitoring" else "Start Monitoring")
        }
    }
}
