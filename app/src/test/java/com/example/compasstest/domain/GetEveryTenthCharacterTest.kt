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
class GetEveryTenthCharacterTest {
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
    fun `given a 20 character string then should return the tenth and the twentieth`() = runTest {
        //GIVEN
        val mockCompassService = mock<CompassService>()
        Mockito.`when`(mockCompassService.getAbout()).thenReturn("12345678912345678912")

        val getEveryTenthCharacter = GetEveryTenthCharacter(mockCompassService)

        //WHEN
        val result = getEveryTenthCharacter.invoke()

        //THEN
        assertEquals("12", result)
    }

    @Test
    fun `given a 30 character string then should return the tenth and the twentieth and the thirtieth`() = runTest {
        //GIVEN
        val mockCompassService = mock<CompassService>()
        Mockito.`when`(mockCompassService.getAbout()).thenReturn("123456789123456789123456789123")

        val getEveryTenthCharacter = GetEveryTenthCharacter(mockCompassService)

        //WHEN
        val result = getEveryTenthCharacter.invoke()

        //THEN
        assertEquals("123", result)
    }

    @Test
    fun `given a 9 character string then should return an empty string`() = runTest {
        //GIVEN
        val mockCompassService = mock<CompassService>()
        Mockito.`when`(mockCompassService.getAbout()).thenReturn("123456789")

        val getEveryTenthCharacter = GetEveryTenthCharacter(mockCompassService)

        //WHEN
        val result = getEveryTenthCharacter.invoke()

        //THEN
        assertEquals("", result)
    }

    @Test
    fun `given an 11 character string then should return only the tenth`() = runTest {
        //GIVEN
        val mockCompassService = mock<CompassService>()
        Mockito.`when`(mockCompassService.getAbout()).thenReturn("1234567891")

        val getEveryTenthCharacter = GetEveryTenthCharacter(mockCompassService)

        //WHEN
        val result = getEveryTenthCharacter.invoke()

        //THEN
        assertEquals("1", result)
    }
}