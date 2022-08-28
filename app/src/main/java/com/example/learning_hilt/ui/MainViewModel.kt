package com.example.learning_hilt.ui

import android.annotation.SuppressLint
import androidx.lifecycle.*
import com.example.learning_hilt.datasource.RunTimeDataSource
import com.example.learning_hilt.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.String.format
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class MainViewModel @Inject constructor(
    private val carGenerator: CarGenerator,
    runTimeDataSource: RunTimeDataSource
) : ViewModel() {

    private val _car = MutableLiveData<Carro>()
    val car: LiveData<Carro> get() = _car

    init {
        randomizeCar()
    }

    fun randomizeCar() {
        _car.value = carGenerator.generateRandomCar()
    }

    val colorsList: List<Cor> = runTimeDataSource.loadColors()

    private fun randomColor(): Cor {
        val i = Random.nextInt(from = 0, until = colorsList.size)
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
        _car.postValue(
            Carro(
                Roda(randomSize(), randomColor()), Motor(randomPower())))
    }
}
