package com.example.focusmonitor.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.focusmonitor.presentation.vm.BLEViewModel

@Composable
fun BLEScreen(
    viewModel: BLEViewModel = hiltViewModel(),
    modifier: Modifier
) {
    val isScanning by viewModel.isScanning.collectAsState()
    val isConnected by viewModel.isConnected.collectAsState()

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = when {
                isScanning -> "Scanning for Devices..."
                isConnected -> "Connected to Device"
                else -> "Not Connected"
            },
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (!isScanning && !isConnected) {
                viewModel.startScan()
            } else if (isConnected) {
                viewModel.disconnect()
            }
        }) {
            Text(
                text = when {
                    isScanning -> "Scanning..."
                    isConnected -> "Disconnect"
                    else -> "Start Scan"
                }
            )
        }
    }
}
