package com.example.starwarsmvp.di

import com.example.starwarsmvp.presenters.PeoplePresenter
import com.example.starwarsmvp.presenters.PeoplePresenterContract
import dagger.Binds
import dagger.Module

@Module
abstract class PresentersModule {

    @Binds
    abstract fun providesPeoplePresenter(
        peoplePresenter: PeoplePresenter
    ): PeoplePresenterContract
}