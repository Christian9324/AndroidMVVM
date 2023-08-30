package com.example.logintestdbcorru.networkapi

import com.example.logintestdbcorru.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {

    private val retrofit = QuotesClient.service

    suspend fun getQuotes() : List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response = retrofit.getAllQuotes()
            response
        }
    }
}