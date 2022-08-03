package com.example.learning_hilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.learning_hilt.R
import com.example.learning_hilt.model.Carro
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG: String  = "debugApp"

    @Inject
    lateinit var carro: Carro

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate: carro com motor de ${carro.motor.valvulas} válvulas e roda aro ${carro.roda.aro}")

    }
}