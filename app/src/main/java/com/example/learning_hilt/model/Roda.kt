package com.example.learning_hilt.model

import dagger.Module
import dagger.hilt.InstallIn
import javax.inject.Inject

class Roda @Inject constructor (var aro: Int, var cor: String) {
}