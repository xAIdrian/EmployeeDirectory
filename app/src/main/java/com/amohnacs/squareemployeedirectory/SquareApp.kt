package com.amohnacs.squareemployeedirectory

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.amohnacs.squareemployeedirectory.dagger.ApplicationModule
import com.amohnacs.squareemployeedirectory.dagger.DaggerApplicationComponent

class SquareApp: Application() {
    lateinit var appComponent: DaggerApplicationComponent

    override fun onCreate() {
        super.onCreate()
        this.appComponent = this.initDagger() as DaggerApplicationComponent
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }

    private fun initDagger() = DaggerApplicationComponent.builder()
        .applicationModule(ApplicationModule(this))
        .build()
}