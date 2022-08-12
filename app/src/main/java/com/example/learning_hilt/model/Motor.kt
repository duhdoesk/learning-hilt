package com.example.learning_hilt.model

import android.annotation.SuppressLint
import java.lang.String
import javax.inject.Inject
import kotlin.random.Random

class Motor @Inject constructor (var potencia: Double) {
}