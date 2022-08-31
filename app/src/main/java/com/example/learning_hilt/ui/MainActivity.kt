package com.example.learning_hilt.ui

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import androidx.activity.viewModels
import com.example.learning_hilt.databinding.ActivityMainBinding
import com.example.learning_hilt.model.Car
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btRandom.setOnClickListener {
            viewModel.randomizeCar()
        }

        viewModel.car.observe(this) {
            setCar(it)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setCar(car: Car) {
        if (Build.VERSION.SDK_INT >= 24) {
            binding.tvMotor.text =
                Html.fromHtml(
                    "It has a <span style=\"color: #000\">${car.engine.power}</span> hp engine",
                    Html.FROM_HTML_MODE_LEGACY
                )
            binding.tvRoda.text =
                Html.fromHtml(
                    """It's also equipped with <span style="color: ${car.wheel.color.hex}">
                        |${car.wheel.color.name}</span> colored ${car.wheel.rim}" wheels""".trimMargin(),
                    Html.FROM_HTML_MODE_LEGACY
                )
        } else {
            binding.tvMotor.text =
                "It has a ${car.engine.power} hp engine"
            binding.tvRoda.text =
                """It's also equipped with ${car.wheel.color.name} colored ${car.wheel.rim}" wheels"""
        }
    }
}
