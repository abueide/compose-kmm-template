package com.dialexa.mnp.android.test

import com.dialexa.mnp.Greeting
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MainActivityTest {
    @Test
    fun greet() {
        assertTrue(Greeting().greeting().contains("Android"))
    }
}
