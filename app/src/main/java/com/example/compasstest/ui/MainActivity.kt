package com.example.compasstest.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: CompassViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val everyTenthChar by viewModel.everyTenthChar.collectAsState()
            val totalWordsCounter by viewModel.totalWordsCounter.collectAsState()

            MainContent(
                everyTenthChar = everyTenthChar,
                totalWordsAmount = totalWordsCounter,
                onPlayCoroutinesClicked = { viewModel.playCoroutines() },
                onRestoreDefaultValuesClicked = { viewModel.restoreDefaultValues() }
            )
        }
    }
}