package com.example.logintestdbcorru

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.logintestdbcorru.databinding.ActivityMainBinding
import com.example.logintestdbcorru.db.dataApplication
import com.example.logintestdbcorru.retro.PaisesClient
import com.example.logintestdbcorru.retro.PaisesNetwork
import com.example.logintestdbcorru.viewmodels.MainActivityViewModel
import com.example.logintestdbcorru.viewmodels.WordViewModelFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainActivityViewModel by viewModels {
        WordViewModelFactory((application as dataApplication).repository)
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            val allNacionalidades = PaisesClient.service.listPaises() ?: emptyList<PaisesNetwork>()

//            mainViewModel.insertNacionalidades(allNacionalidades)
        }
    }
}