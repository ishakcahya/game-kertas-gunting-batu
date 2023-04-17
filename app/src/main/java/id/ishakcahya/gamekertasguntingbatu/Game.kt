package id.ishakcahya.gamekertasguntingbatu

import kotlin.random.Random

object Game {

    private val option = listOf("BATU", "GUNTING", "KERTAS")

    fun pickComputerOption(): String = option[Random.nextInt(0, 3)]

    fun pickNextComputerOption(option: String): Int = optionNextImageViewCom[option]!!

    private val optionNextImageViewCom = mapOf(
        "BATU" to 1,
        "GUNTING" to 2,
        "KERTAS" to 3,
    )

    private val rules = mapOf(
        "BATU-GUNTING" to true,
        "BATU-KERTAS" to false,
        "GUNTING-KERTAS" to true,
        "GUNTING-BATU" to false,
        "KERTAS-BATU" to true,
        "KERTAS-GUNTING" to false
    )

    fun isDraw(from: String, to: String): Boolean = from == to

    fun isWin(from: String, to: String): Boolean = rules["$from-$to"]!!

}