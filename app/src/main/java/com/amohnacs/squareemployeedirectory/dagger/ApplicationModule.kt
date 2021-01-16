package com.amohnacs.squareemployeedirectory.dagger

import android.app.Application
import android.content.Context
import com.amohnacs.squareemployeedirectory.domain.RetrofitService
import com.amohnacs.squareemployeedirectory.domain.RetrofitServiceFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    fun providesApplication(): Application = application

    @Provides
    @Singleton
    fun providesApplicationContext(): Context = application

    @Provides
    @Singleton
    fun provideRetrofitClient() = RetrofitServiceFactory.createAmiiboService(
            RetrofitService::class.java
    )
}