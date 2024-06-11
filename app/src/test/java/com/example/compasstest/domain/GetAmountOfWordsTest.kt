package com.example.compasstest.domain

import com.example.compasstest.service.CompassService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.junit.Assert.*

@OptIn(ExperimentalCoroutinesApi::class)
class GetAmountOfWordsTest {
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `given a text with 2 html dividers and 3 words then it should count up to 5`() = runTest {
        //GIVEN
        val mockCompassService = mock<CompassService>()
        Mockito.`when`(mockCompassService.getAbout()).thenReturn("<p> Compass Hello World </p>")

        val getAmountOfWords = GetAmountOfWords(mockCompassService)

        //WHEN
        val result = getAmountOfWords.invoke()

        //THEN
        assertEquals(5, result)
    }

    @Test
    fun `given multiple white spaces then should it count no word at all`() = runTest {
        //GIVEN
        val mockCompassService = mock<CompassService>()
        Mockito.`when`(mockCompassService.getAbout()).thenReturn("    ")

        val getAmountOfWords = GetAmountOfWords(mockCompassService)

        //WHEN
        val result = getAmountOfWords.invoke()

        //THEN
        assertEquals(0, result)
    }

    @Test
    fun `given a text that starts and ends with spaces with one word in the middle then it should only count up ot three`() = runTest {
        //GIVEN
        val mockCompassService = mock<CompassService>()
        Mockito.`when`(mockCompassService.getAbout()).thenReturn(" a ")

        val getAmountOfWords = GetAmountOfWords(mockCompassService)

        //WHEN
        val result = getAmountOfWords.invoke()

        //THEN
        assertEquals(1, result)
    }
}