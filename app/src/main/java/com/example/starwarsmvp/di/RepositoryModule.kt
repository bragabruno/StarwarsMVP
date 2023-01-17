package com.example.starwarsmvp.di

import com.example.starwarsmvp.rest.StarWarsRepository
import com.example.starwarsmvp.rest.StarWarsRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    /**
     * This works similar to PROVIDES but you don't
     * need to create any instance
     * of the object, instead DAGGER will bind all the
     * objects needed to the implementation
     *
     * This works mainly for interfaces and abstract classes
     */
    @Binds
    abstract fun bindsStarWarsRepository(
        starWarsRepositoryImpl: StarWarsRepositoryImpl
    ): StarWarsRepository
}