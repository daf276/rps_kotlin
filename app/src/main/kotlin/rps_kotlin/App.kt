package rps_kotlin

data class Results(val wins: Int, val losses: Int, val draws: Int)

enum class RoundResult {
    WIN, LOSS, DRAW
}

enum class Hand {
    ROCK, PAPER, SCISSORS
}

val BEATS = mapOf(Hand.ROCK to Hand.SCISSORS, Hand.SCISSORS to Hand.PAPER, Hand.PAPER to Hand.ROCK)

fun beats(hand1: Hand, hand2: Hand): Boolean = BEATS[hand1] == hand2

fun roundResult(mainHand: Hand, opposingHand: Hand): RoundResult = when {
    beats(mainHand, opposingHand) -> RoundResult.WIN
    beats(opposingHand, mainHand) -> RoundResult.LOSS
    else -> RoundResult.DRAW
}

fun playRounds(numberOfRounds: Int, mainPlayerStrategy: () -> Hand, opposingPlayerStrategy: () -> Hand): Results {
    val outcomes = (0 until numberOfRounds).map { roundResult(mainPlayerStrategy(), opposingPlayerStrategy()) }
    return Results(outcomes.count { it == RoundResult.WIN }, outcomes.count { it == RoundResult.LOSS }, outcomes.count { it == RoundResult.DRAW })
}

fun chooseRock(): Hand = Hand.ROCK
fun chooseRandom(): Hand = Hand.values().random()

fun main() {
    val results = playRounds(100, ::chooseRandom, ::chooseRock)

    println("The main player has won ${results.wins} times")
    println("The opposing player has won ${results.losses} times")
    println("There were ${results.draws} draws")
}