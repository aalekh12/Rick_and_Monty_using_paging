package com.modern.rickandmonty.network

import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServices {
    @GET("character")
    suspend fun getDataFromAPI(@Query("page") query: Int):RickAndMortyList

}