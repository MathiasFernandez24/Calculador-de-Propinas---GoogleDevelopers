package com.example.dado

import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {
    @Test
    fun generates_number(){
        val dice = MainActivity.Dice(6)
        val rollResult = dice.roll()
        assertTrue("El valor del dado no es entre 1 y 6", rollResult in 1..6)
    }
}