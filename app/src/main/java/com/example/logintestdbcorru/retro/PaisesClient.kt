package com.example.logintestdbcorru.retro

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PaisesClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.8.2:8080")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(PaisesService::class.java)

}