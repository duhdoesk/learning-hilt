package com.example.learning_hilt.model

import kotlinx.serialization.Serializable

@Serializable
data class Color (val name: String, val hex: String) {
}