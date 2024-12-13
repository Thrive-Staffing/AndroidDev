package com.example.focusmonitor.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class BLEViewModel @Inject constructor() : ViewModel() {
    private val _isScanning = MutableStateFlow(false)
    val isScanning: StateFlow<Boolean> = _isScanning

    private val _isConnected = MutableStateFlow(false)
    val isConnected: StateFlow<Boolean> = _isConnected

    fun startScan() {
        _isScanning.value = true
        viewModelScope.launch {
            delay(2000L)
            _isConnected.value = true
            _isScanning.value = false
        }
    }

    fun disconnect() {
        _isConnected.value = false
    }
}
