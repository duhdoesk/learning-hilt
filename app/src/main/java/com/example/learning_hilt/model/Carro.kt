package com.example.learning_hilt.model

import javax.inject.Inject

class Carro @Inject constructor(val roda: Roda, val motor: Motor) {
}