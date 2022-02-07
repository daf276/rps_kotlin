package rps_kotlin

enum class Hand {
    ROCK, PAPER, SCISSORS
}

val BEATS = mapOf(Hand.ROCK to Hand.SCISSORS, Hand.SCISSORS to Hand.PAPER, Hand.PAPER to Hand.ROCK)

fun beats(hand1: Hand, hand2: Hand): Boolean = BEATS[hand1] == hand2

fun chooseRock(): Hand = Hand.ROCK

fun chooseRandom(): Hand = Hand.values().random()

fun main() {
    var player1Wins = 0
    var player2Wins = 0
    var draws = 0

    repeat(100) {
        val player1 = chooseRock()
        val player2 = chooseRandom()

        when {
            beats(player1, player2) -> player1Wins++
            beats(player2, player1) -> player2Wins++
            else -> draws++
        }
    }

    println("Player 1 has won $player1Wins times")
    println("Player 2 has won $player2Wins times")
    println("There were $draws draws")
}