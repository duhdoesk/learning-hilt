package com.example.learning_hilt.model

import com.example.learning_hilt.data.local.ColorLocalDataSource
import java.math.RoundingMode
import java.text.DecimalFormat
import javax.inject.Inject
import kotlin.random.Random

class CarGenerator @Inject constructor(private val colorLocalDataSource: ColorLocalDataSource) {

    private fun randomAro(): Int {
        return Random.nextInt(from = 13, until = 20)
    }

    private fun randomColor(): Color {
        val colors = colorLocalDataSource.getColors()
        if (colors.isEmpty()) return Color("black", "#000")

        val index = Random.nextInt(from = 0, until = colors.size)
        return colors[index]
    }

    private fun randomRoda(): Roda = Roda(randomAro(), randomColor())

    private fun randomMotor(): Motor {
        val formatter = DecimalFormat("#.##").apply {
            roundingMode = RoundingMode.DOWN
        }

        val random = Random.nextDouble(from = 160.0, until = 400.1)
        val formatted = formatter.format(random)

        return Motor(formatted.toDouble())
    }


    fun generateRandomCar(): Carro {
        return Carro(randomRoda(), randomMotor())
    }
}