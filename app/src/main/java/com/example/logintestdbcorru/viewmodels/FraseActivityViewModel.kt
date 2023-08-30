package com.example.logintestdbcorru.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.logintestdbcorru.model.QuoteModel
import com.example.logintestdbcorru.model.QuoteProvider
import com.example.logintestdbcorru.usecase.GetQuoteUseCase
import com.example.logintestdbcorru.usecase.GetRandomQuoteUC
import kotlinx.coroutines.launch

class FraseActivityViewModel : ViewModel(){

    val quoteData by lazy { MutableLiveData<QuoteModel>()}
    val isLoading by lazy { MutableLiveData<Boolean>() }

    var getQuoteUseCase = GetQuoteUseCase()
    var getRandomQuoteUC = GetRandomQuoteUC()

    fun onCreate(){
        viewModelScope.launch {

            isLoading.value = true

            val result : List<QuoteModel>? = getQuoteUseCase()

            if (!result.isNullOrEmpty()){
                QuoteProvider.quotes = result
                quoteData.value = QuoteProvider.randomQuote()
                isLoading.value = false
            }
            isLoading.value = false
        }
    }

    fun getRandomQuote() {
        isLoading.value = true
        val quote : QuoteModel? =  getRandomQuoteUC()
        if (quote != null){
            quoteData.value = quote
        }
        isLoading.value = false

    }
}