package com.example.learning_hilt.model

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.example.learning_hilt.di.AppModule.provideRoda
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject

class Carro @Inject constructor(val roda: Roda, val motor: Motor) {
}