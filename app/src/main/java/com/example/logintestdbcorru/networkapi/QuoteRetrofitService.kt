package com.example.logintestdbcorru.networkapi

import com.example.logintestdbcorru.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteRetrofitService {
    @GET("/info/frases")
    suspend fun getAllQuotes() : List<QuoteModel>
}