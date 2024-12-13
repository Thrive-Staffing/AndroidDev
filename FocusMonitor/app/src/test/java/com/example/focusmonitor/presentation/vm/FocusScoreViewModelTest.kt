package com.example.focusmonitor.presentation.vm

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FocusScoreViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    private lateinit var viewModel: FocusScoreViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher) // Set Main dispatcher to a test dispatcher
        viewModel = FocusScoreViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // Reset Main dispatcher to its original state
    }

    @Test
    fun `focus score updates within range`() = runTest {
        viewModel.startMonitoring()

        // Simulate the passage of time
        advanceTimeBy(5000L)

        // Verify that the focus score is within the expected range
        val focusScore = viewModel.focusScore.value
        assertTrue("Focus score should be between 0 and 100", focusScore in 0..100)

        viewModel.stopMonitoring()
    }
}
