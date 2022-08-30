package com.example.learning_hilt.ui

import androidx.lifecycle.*
import com.example.learning_hilt.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val carGenerator: CarGenerator
) : ViewModel() {

    private val _car = MutableLiveData<Carro>()
    val car: LiveData<Carro> get() = _car

    init {
        randomizeCar()
    }

    fun randomizeCar() {
        _car.value = carGenerator.generateRandomCar()
    }
}
