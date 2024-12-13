package com.example.focusmonitor.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FocusScoreViewModel @Inject constructor() : ViewModel() {
    private val _focusScore = MutableStateFlow(0)
    val focusScore: StateFlow<Int> = _focusScore

    private var job: Job? = null

    fun startMonitoring() {
        job = viewModelScope.launch {
            while (true) {
                _focusScore.value = (0..100).random()
                delay(5000L)
            }
        }
    }

    fun stopMonitoring() {
        job?.cancel()
    }
}
