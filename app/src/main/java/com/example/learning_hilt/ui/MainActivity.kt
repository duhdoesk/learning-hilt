package com.example.learning_hilt.ui

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import com.example.learning_hilt.databinding.ActivityMainBinding
import com.example.learning_hilt.model.Carro
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val carObserver = androidx.lifecycle.Observer<Carro> { car ->
            if (Build.VERSION.SDK_INT >= 24) {
                binding.tvMotor.text =
                    Html.fromHtml("It has a <span style=\"color: #000\">${car.motor.potencia}</span> hp engine", Html.FROM_HTML_MODE_LEGACY)
                binding.tvRoda.text =
                    Html.fromHtml("""It's also equipped with <span style="color: ${car.roda.cor.hex}">${car.roda.cor.nome}</span> colored ${car.roda.aro}" wheels""", Html.FROM_HTML_MODE_LEGACY)
            } else {
                binding.tvMotor.text = "It has a ${car.motor.potencia} hp engine"
                binding.tvRoda.text = """It's also equipped with ${car.roda.cor.nome} colored ${car.roda.aro}" wheels"""
            }
        }

        val btRandom: Button = binding.btRandom
        btRandom.setOnClickListener(View.OnClickListener {
            viewModel.randomizeMyCar()
        })

        viewModel.car.observe(this, carObserver)
    }
}
