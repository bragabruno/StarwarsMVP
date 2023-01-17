package com.example.starwarsmvp.rest

import com.example.starwarsmvp.model.GeneralResponse
import com.example.starwarsmvp.utils.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StarWarsAPI {

    @GET(PEOPLE_ENDPOINT)
    suspend fun getPeople(
        @Path(PEOPLE_ID) id: String? = null
    ): Response<GeneralResponse>

    @GET(PLANETS_ENDPOINT)
    suspend fun getPlanets(
        @Path(PLANETS_ID) id: String? = null
    ): Response<GeneralResponse>

    @GET(STARSHIPS_ENDPOINT)
    suspend fun getStarShips(
        @Path(STARSHIP_ID) id: String? = null
    ): Response<GeneralResponse>
}