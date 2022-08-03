package com.example.learning_hilt.model

import javax.inject.Inject

class Motor @Inject constructor (var valvulas: Int, var potencia: Double) {
}