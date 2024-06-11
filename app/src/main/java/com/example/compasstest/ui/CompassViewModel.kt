package com.example.compasstest.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compasstest.domain.GetAmountOfWords
import com.example.compasstest.domain.GetEveryTenthCharacter
import com.example.compasstest.ui.theme.everyTenthCharDefaultText
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
        MutableStateFlow(everyTenthCharDefaultText)
    val everyTenthChar = _everyTenthChar.asStateFlow()

    private val _totalWordsCounter =
        MutableStateFlow(COUNTER_DEFAULT_VALUE)
    val totalWordsCounter = _totalWordsCounter.asStateFlow()

    fun playCoroutines() {
        viewModelScope.launch(Dispatchers.IO) {
            _everyTenthChar.value = getEveryTenthCharacter.invoke()
        }

        viewModelScope.launch(Dispatchers.IO) {
            _totalWordsCounter.value = getAmountOfWords.invoke()
        }
    }

    fun restoreDefaultValues() {
        _everyTenthChar.value = everyTenthCharDefaultText
        _totalWordsCounter.value = COUNTER_DEFAULT_VALUE
    }

    companion object {
        private const val COUNTER_DEFAULT_VALUE = 0
    }
}