package com.example.logintestdbcorru.networkapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://inicio.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}