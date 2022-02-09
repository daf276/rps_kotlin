/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package rps_kotlin

import kotlin.test.Test
import kotlin.test.assertEquals

class AppTest {
    @Test
    fun testRockBeats() {
        assertEquals(beats(Hand.ROCK, Hand.ROCK), false)
        assertEquals(beats(Hand.ROCK, Hand.PAPER), false)
        assertEquals(beats(Hand.ROCK, Hand.SCISSORS), true)
    }

    @Test
    fun testPaperBeats() {
        assertEquals(beats(Hand.PAPER, Hand.ROCK), true)
        assertEquals(beats(Hand.PAPER, Hand.PAPER), false)
        assertEquals(beats(Hand.PAPER, Hand.SCISSORS), false)
    }

    @Test
    fun testScissorsBeats() {
        assertEquals(beats(Hand.SCISSORS, Hand.ROCK), false)
        assertEquals(beats(Hand.SCISSORS, Hand.PAPER), true)
        assertEquals(beats(Hand.SCISSORS, Hand.SCISSORS), false)
    }

    @Test
    fun testRoundResults() {
        assertEquals(roundResult(Hand.SCISSORS, Hand.ROCK), RoundResult.LOSS)
        assertEquals(roundResult(Hand.ROCK, Hand.ROCK), RoundResult.DRAW)
        assertEquals(roundResult(Hand.PAPER, Hand.ROCK), RoundResult.WIN)
    }

    @Test
    fun testPlayRoundsSimpleStrategyDraws() {
        val numberOfRounds = 10
        val results = playRounds(numberOfRounds, ::chooseRock, ::chooseRock)
        assertEquals(results.draws, numberOfRounds)
        assertEquals(results.wins, 0);
        assertEquals(results.losses, 0);
    }

    @Test
    fun testPlayRoundsSimpleStrategyWins() {
        val paperStrat = { Hand.PAPER }
        val numberOfRounds = 10
        val results = playRounds(numberOfRounds, paperStrat, ::chooseRock)
        assertEquals(results.wins, numberOfRounds)
        assertEquals(results.draws, 0);
        assertEquals(results.losses, 0);
    }

    @Test
    fun testPlayRoundsSimpleStrategyLosses() {
        val scissorStrategy = { Hand.SCISSORS }
        val numberOfRounds = 10
        val results = playRounds(numberOfRounds, scissorStrategy, ::chooseRock)
        assertEquals(results.losses, numberOfRounds)
        assertEquals(results.wins, 0);
        assertEquals(results.draws, 0);
    }
}
