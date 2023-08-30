package com.example.logintestdbcorru

import com.example.logintestdbcorru.model.QuoteModel
import com.example.logintestdbcorru.model.QuoteProvider
import com.example.logintestdbcorru.networkapi.QuoteService

class QuoteRepository {

    val api = QuoteService()

    suspend fun getAllQuotes() : List<QuoteModel>{
        val response : List<QuoteModel> = api.getQuotes()
//        QuoteProvider.quotes = response
        return response
    }
}