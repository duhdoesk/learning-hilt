package com.example.learning_hilt.model

import kotlinx.serialization.Serializable
import javax.inject.Inject

@Serializable
data class Cor @Inject constructor(val nome: String, val hex: String) {
}