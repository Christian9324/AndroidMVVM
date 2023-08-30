package com.example.logintestdbcorru

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.logintestdbcorru.databinding.ActivityFraseBinding
import com.example.logintestdbcorru.viewmodels.FraseActivityViewModel

class FraseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFraseBinding

    private val dataActivityViewM : FraseActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFraseBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        dataActivityViewM.onCreate()

        dataActivityViewM.quoteData.observe(this){
            binding.tvAuthor.text = it.author
            binding.tvQuote.text = it.quote
        }

        dataActivityViewM.isLoading.observe(this){
            binding.progressB.isVisible = it
        }

        binding.viewContainer.setOnClickListener {
            dataActivityViewM.getRandomQuote()
        }
    }
}