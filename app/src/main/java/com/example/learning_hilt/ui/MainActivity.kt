package com.example.learning_hilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.learning_hilt.R
import com.example.learning_hilt.databinding.ActivityMainBinding
import com.example.learning_hilt.model.Carro
import dagger.hilt.android.AndroidEntryPoint
import java.util.Observer
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var c: Carro

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        refreshViews()

        val viewModel: MainViewModel by viewModels()
        val btRandom: Button = binding.btRandom

        btRandom.setOnClickListener(View.OnClickListener {
            val att: List<String> = viewModel.sorteiaCarro()
            c.roda.cor = att[0]
            c.roda.aro = att[1].toInt()
            c.motor.potencia = att[2].toDouble()

            refreshViews()
        })
    }

    private fun refreshViews() {
        binding.tvCarro.text = "This is my car"
        binding.tvMotor.text = "It haves a ${c.motor.potencia} hp engine"
        binding.tvRoda.text = """It's also equipped with ${c.roda.cor} colored ${c.roda.aro}" wheels"""
    }
}