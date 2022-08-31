package com.example.learning_hilt.data.local

import com.example.learning_hilt.util.JsonFileReader
import com.example.learning_hilt.model.Color
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import javax.inject.Inject

class ColorLocalDataSource @Inject constructor (private val jsonFileReader: JsonFileReader) {

    companion object {
        private const val COLORS_JSON = "colors.json"
    }

    fun getColors(): List<Color> {
        val rawJson = jsonFileReader.readJsonAsset(COLORS_JSON) ?: return emptyList()
        val jsonReader = Json { isLenient = true }
        return jsonReader.decodeFromString(rawJson)
    }
}