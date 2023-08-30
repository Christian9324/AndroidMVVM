package com.example.logintestdbcorru.usecase

import com.example.logintestdbcorru.model.QuoteModel
import com.example.logintestdbcorru.model.QuoteProvider

class GetRandomQuoteUC {

    operator fun invoke(): QuoteModel?{
        val quotes : List<QuoteModel> = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}