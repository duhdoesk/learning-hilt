package com.example.learning_hilt.di

import android.content.Context
import com.example.learning_hilt.model.Carro
import com.example.learning_hilt.model.Cor
import com.example.learning_hilt.model.Motor
import com.example.learning_hilt.model.Roda
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context) : BaseApplication {
        return app as BaseApplication
    }

    @Singleton
    @Provides
    fun provideRoda(cor: Cor): Roda {
        return Roda(16, cor)
    }

    @Singleton
    @Provides
    fun provideMotor(): Motor {
        return Motor(400.0)
    }

    @Singleton
    @Provides
    fun provideCarro(roda: Roda, motor: Motor) : Carro {
        return Carro(roda, motor)
    }

    @Singleton
    @Provides
    fun provideCor() : Cor {
        return Cor("black", "#000")
    }

    @Singleton
    @Provides
    fun provideContext(@ApplicationContext context: Context) : Context {
        return context
    }

}