package com.example.starwarsmvp.di

import com.example.starwarsmvp.MainActivity
import com.example.starwarsmvp.view.PeopleFragment
import com.example.starwarsmvp.view.PlanetsFragment
import com.example.starwarsmvp.view.StarshipFragment
import dagger.Component

/**
 * This is the interface component that DAGGER
 * will take in order to inject the objects when needed
 *
 * Using annotation Component allows to
 * tell dagger which component to use
 *
 * YOU NEED TO DEFINE THE MODULES THAT YOUR COMPONENT WILL USE
 * TO INJECT THE DEPENDENCIES
 */
@Component(
    modules = [
        NetworkModule::class,
        RepositoryModule::class,
        ApplicationModule::class,
        PresentersModule::class
    ]
)
interface StarWarsComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(peopleFragment: PeopleFragment)
    fun inject(planetsFragment: PlanetsFragment)
    fun inject(starshipFragment: StarshipFragment)
}
