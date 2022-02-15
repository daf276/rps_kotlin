package rps_kotlin

data class Results(val wins: Int, val losses: Int, val draws: Int)

enum class RoundResult {
    WIN, LOSS, DRAW
}

enum class Hand(val beats: () -> Set<Hand>) {
    ROCK({ setOf(SCISSORS, LIZARD) }),
    PAPER({ setOf(ROCK, SPOCK) }),
    SCISSORS({ setOf(PAPER, LIZARD) }),
    LIZARD({ setOf(PAPER, SPOCK) }),
    SPOCK({ setOf(ROCK, SCISSORS) });
}

fun roundResult(mainHand: Hand, opposingHand: Hand): RoundResult = when (opposingHand){
    mainHand -> RoundResult.DRAW
    in mainHand.beats() -> RoundResult.WIN
    else -> RoundResult.LOSS
}

fun playRounds(numberOfRounds: Int, mainPlayerStrategy: () -> Hand, opposingPlayerStrategy: () -> Hand): Results =
    generateSequence { roundResult(mainPlayerStrategy(), opposingPlayerStrategy()) }
            .take(numberOfRounds).fold(Results(0,0,0)){ sum, add -> when(add) {
                RoundResult.WIN -> sum.copy(wins = sum.wins + 1)
                RoundResult.LOSS -> sum.copy(losses = sum.losses + 1)
                RoundResult.DRAW -> sum.copy(draws = sum.draws + 1)
            }}

fun chooseRock(): Hand = Hand.ROCK
fun chooseRandom(): Hand = Hand.values().random()

fun main() {
    val results = playRounds(100, ::chooseRandom, ::chooseRock)

    println("The main player has won ${results.wins} times")
    println("The opposing player has won ${results.losses} times")
    println("There were ${results.draws} draws")
}