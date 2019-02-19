package com.java.practice.utils

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DateUtilsKtTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun currentTimeInMills() {
      print("currentTime::${DateUtils.currentTimeInMills()}")
    }
}