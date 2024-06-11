package com.example.compasstest.domain

import com.example.compasstest.service.CompassService
import javax.inject.Inject

class GetAmountOfWords @Inject constructor(
    private val compassService: CompassService
) {

    suspend fun invoke(): Int {
        val responseFromService = compassService.getAbout()
        val caseInsensitiveEveryWhiteSpaceRegex = "\\s+".toRegex(RegexOption.IGNORE_CASE)
        return if (responseFromService.isNotBlank())
            responseFromService.trim().split(caseInsensitiveEveryWhiteSpaceRegex).size
        else 0
    }
}