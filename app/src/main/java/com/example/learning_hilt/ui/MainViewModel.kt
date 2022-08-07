package com.example.learning_hilt.ui

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import java.lang.String.format
import kotlin.random.Random

class MainViewModel : ViewModel() {

    val colorsList: List<String> = listOf(
        "blue",
        "yellow",
        "green",
        "red",
        "purple",
        "orange",
        "black",
        "silver",
        "white",
        "gold"
    )

    private fun sorteiaCor(): String {
        val i = Random.nextInt(from = 0, until = 10)
        return colorsList[i]
    }

    @SuppressLint("DefaultLocale")
    private fun sorteiaPotencia(): Double {
        return format("%.2f", Random.nextDouble(from = 160.0, until = 400.1)).toDouble()
    }

    private fun sorteiaAro(): Int {
        return Random.nextInt(from = 13, until = 20)
    }

    fun sorteiaCarro(): List<String> {
        return listOf(
            sorteiaCor(),
            sorteiaAro().toString(),
            sorteiaPotencia().toString()
        )
    }

}