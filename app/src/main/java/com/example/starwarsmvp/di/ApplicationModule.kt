package com.example.starwarsmvp.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    fun providesContext(): Context =
        application.applicationContext
}