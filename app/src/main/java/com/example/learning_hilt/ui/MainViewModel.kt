package com.example.learning_hilt.ui

import android.annotation.SuppressLint
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.learning_hilt.model.Carro
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.String.format
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel(), LifecycleObserver {

    @Inject
    lateinit var c: Carro

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

    private fun randomColor(): String {
        val i = Random.nextInt(from = 0, until = 10)
        return colorsList[i]
    }

    @SuppressLint("DefaultLocale")
    private fun randomPower(): Double {
        return format("%.2f", Random.nextDouble(from = 160.0, until = 400.1)).toDouble()
    }

    private fun randomSize(): Int {
        return Random.nextInt(from = 13, until = 20)
    }

    fun randomCar(): Carro {
        c.roda.cor = randomColor()
        c.roda.aro = randomSize()
        c.motor.potencia = randomPower()

        return c
    }

}