package com.example.learning_hilt.datasource

import com.example.learning_hilt.model.Cor
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import javax.inject.Inject

class RunTimeDataSource @Inject constructor (private val jsonFileReader: JsonFileReader) {

    companion object {
        private const val COLORS_JSON = "colors.json"
    }

    fun loadColors(): List<Cor> {
        val rawJson = jsonFileReader.readJsonAsset(COLORS_JSON)
            ?: return emptyList()

        val jsonReader = Json { isLenient = true }
        return jsonReader.decodeFromString(rawJson)
    }
}