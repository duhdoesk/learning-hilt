package com.example.learning_hilt.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.learning_hilt.R
import com.example.learning_hilt.databinding.ActivityMainBinding
import com.example.learning_hilt.model.Carro
import com.example.learning_hilt.model.Motor
import com.example.learning_hilt.model.Roda
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

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
            binding.tvMotor.text = "It haves a ${car.motor.potencia} hp engine"
            binding.tvRoda.text = """It's also equipped with ${car.roda.cor} colored ${car.roda.aro}" wheels"""
        }

        val btRandom: Button = binding.btRandom
        btRandom.setOnClickListener(View.OnClickListener {
            viewModel.randomizeMyCar()
        })

        viewModel.c.observe(this, carObserver)
    }
}
