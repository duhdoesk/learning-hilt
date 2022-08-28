package com.example.learning_hilt.model

import javax.inject.Inject

class CarGenerator @Inject constructor() {
    fun generateRandomCar(): Carro {
        return Carro(
            Roda(15, Cor("black", "#000")),
            Motor(400.0)
        )
    }
}