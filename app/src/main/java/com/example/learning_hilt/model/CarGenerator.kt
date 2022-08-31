package com.example.learning_hilt.model

import com.example.learning_hilt.data.local.ColorLocalDataSource
import java.math.RoundingMode
import java.text.DecimalFormat
import javax.inject.Inject
import kotlin.random.Random

class CarGenerator @Inject constructor(private val colorLocalDataSource: ColorLocalDataSource) {

    private fun randomRim(): Int {
        return Random.nextInt(from = 13, until = 20)
    }

    private fun randomColor() : com.example.learning_hilt.model.Color {
        val colors = colorLocalDataSource.getColors()
        if (colors.isEmpty()) return Color("black", "#000")

        val index = Random.nextInt(from = 0, until = colors.size)
        return colors[index]
    }

    private fun randomWheel(): Wheel = Wheel(randomRim(), randomColor())

    private fun randomEngine(): Engine {
        val formatter = DecimalFormat("#.##").apply {
            roundingMode = RoundingMode.DOWN
        }

        val random = Random.nextDouble(from = 160.0, until = 400.1)
        val formatted = formatter.format(random)

        return Engine(formatted.toDouble())
    }

    fun generateRandomCar(): Car {
        return Car(randomWheel(), randomEngine())
    }
}