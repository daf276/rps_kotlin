/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package rps_kotlin

enum class Hand {
    ROCK, PAPER, SCISSORS
}

private fun chooseRock(): Hand {
    return Hand.ROCK
}

fun main() {
    repeat(100) {
        println(it)
    }
}