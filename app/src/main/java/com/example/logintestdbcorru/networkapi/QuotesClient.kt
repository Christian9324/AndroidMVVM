package com.example.logintestdbcorru.networkapi

import com.example.logintestdbcorru.retro.PaisesService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  QuotesClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.8.2:8080")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(QuoteRetrofitService::class.java)
}