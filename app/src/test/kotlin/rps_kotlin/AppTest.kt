/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package rps_kotlin

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class AppTest {
    @Test fun rockStratChoosesRock() {
        assertEquals(chooseRock(), Hand.ROCK, "Rock chooser should always choose Rock")
    }

    @Test fun testRockBeats() {
        assertEquals(beats(Hand.ROCK, Hand.ROCK), false)
        assertEquals(beats(Hand.ROCK, Hand.PAPER), false)
        assertEquals(beats(Hand.ROCK, Hand.SCISSORS), true)
    }

    @Test fun testPaperBeats() {
        assertEquals(beats(Hand.PAPER, Hand.ROCK), true)
        assertEquals(beats(Hand.PAPER, Hand.PAPER), false)
        assertEquals(beats(Hand.PAPER, Hand.SCISSORS), false)
    }

    @Test fun testScissorsBeats() {
        assertEquals(beats(Hand.SCISSORS, Hand.ROCK), false)
        assertEquals(beats(Hand.SCISSORS, Hand.PAPER), true)
        assertEquals(beats(Hand.SCISSORS, Hand.SCISSORS), false)
    }

}
