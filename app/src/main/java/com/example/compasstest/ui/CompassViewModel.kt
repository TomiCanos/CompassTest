package com.example.compasstest.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compasstest.domain.GetAmountOfWords
import com.example.compasstest.domain.GetEveryTenthCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompassViewModel @Inject constructor(
    private val getEveryTenthCharacter: GetEveryTenthCharacter,
    private val getAmountOfWords: GetAmountOfWords
) : ViewModel() {
    private val _everyTenthChar =
        MutableStateFlow("This will display every tenth character from the about page")
    val everyTenthChar = _everyTenthChar.asStateFlow()

    private val _totalWordsCounter =
        MutableStateFlow(0)
    val totalWordsCounter = _totalWordsCounter.asStateFlow()

    fun playCoroutines() {
        viewModelScope.launch(Dispatchers.IO) {
            _everyTenthChar.value = getEveryTenthCharacter.invoke()
        }

        viewModelScope.launch(Dispatchers.IO) {
            _totalWordsCounter.value = getAmountOfWords.invoke()
        }
    }
}