package com.example.learning_hilt.ui

import android.annotation.SuppressLint
import androidx.lifecycle.*
import com.example.learning_hilt.model.CarGenerator
import com.example.learning_hilt.model.Carro
import com.example.learning_hilt.model.Motor
import com.example.learning_hilt.model.Roda
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.String.format
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel(), LifecycleObserver {

    @Inject
    lateinit var randomCar: CarGenerator
    val c: MutableLiveData<Carro> by lazy {
        MutableLiveData<Carro>(generateNewCar())
    }

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

    fun generateNewCar(): Carro {
        return randomCar.generateRandomCar()
    }

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

    fun randomizeMyCar() {
        c.postValue(
            Carro(
                Roda(randomSize(), randomColor()), Motor(randomPower())))
    }
}
