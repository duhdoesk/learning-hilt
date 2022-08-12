package com.example.learning_hilt.model

import javax.inject.Inject

class CarGenerator @Inject constructor() {
    fun generateRandomCar(): Carro {
        return Carro(
            Roda(15, "black"),
            Motor(400.0)
        )
    }
}