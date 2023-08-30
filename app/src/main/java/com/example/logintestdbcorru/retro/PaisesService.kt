package com.example.logintestdbcorru.retro

import retrofit2.Call
import retrofit2.http.GET

interface PaisesService {

    @GET("/info/Paises")
    suspend fun listPaises() : PaisesNetwork
}