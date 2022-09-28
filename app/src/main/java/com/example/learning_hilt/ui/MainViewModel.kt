package com.example.learning_hilt.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.*
import com.example.learning_hilt.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val carGenerator: CarGenerator
) : ViewModel() {

    var car by mutableStateOf<Car?>(null)
    private set

    init {
        setCurrentCar()
    }

    fun setCurrentCar() {
        car = carGenerator.generateRandomCar()
    }
}
