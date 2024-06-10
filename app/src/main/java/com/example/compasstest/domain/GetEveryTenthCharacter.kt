package com.example.compasstest.domain

import com.example.compasstest.service.CompassService
import javax.inject.Inject

class GetEveryTenthCharacter @Inject constructor(
    private val compassService: CompassService
) {

    suspend fun invoke(): String {
        val responseFromService = compassService.getAbout()
        var i = 9
        val stringOnlyContainingEveryTenthChar = StringBuilder()

        while (i < responseFromService.length) {
            stringOnlyContainingEveryTenthChar.append(responseFromService[i])
            i += 10
        }

        return stringOnlyContainingEveryTenthChar.toString()
    }
}