package com.example.logintestdbcorru.usecase

import com.example.logintestdbcorru.QuoteRepository
import com.example.logintestdbcorru.model.QuoteModel

class GetQuoteUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()
}