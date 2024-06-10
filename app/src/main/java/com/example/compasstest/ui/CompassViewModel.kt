package com.example.compasstest.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compasstest.domain.GetEveryTenthCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompassViewModel @Inject constructor(
    private val getEveryTenthCharacter: GetEveryTenthCharacter
) : ViewModel() {
    private val _response = MutableStateFlow("Show every tenth character")
    val response = _response.asStateFlow()

    fun getEveryTenthCharacter() {
        viewModelScope.launch {
            _response.value = getEveryTenthCharacter.invoke()
        }
    }
}