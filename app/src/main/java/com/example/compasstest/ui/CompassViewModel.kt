package com.example.compasstest.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CompassViewModel @Inject constructor() : ViewModel() {
    private val _response = MutableStateFlow("Show every tenth character")
    val response = _response.asStateFlow()

    fun getEveryTenthCharacter() {
        _response.value += "r"
    }
}