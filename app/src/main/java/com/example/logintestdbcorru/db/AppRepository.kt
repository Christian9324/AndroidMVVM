package com.example.logintestdbcorru.db

import com.example.logintestdbcorru.retro.PaisesNetwork
import com.example.logintestdbcorru.retro.PaisesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class AppRepository(
    private val marcadorDao: MarcadorDao,
    private val nacionalidadDao: NacionalidadDao,
) {
    val allMarcadores: Flow<List<MarcadorEntity>> = marcadorDao.getAllScores()

    val allNacionalidades: Flow<List<NacionalidadEntity>> = nacionalidadDao.getAllPaises()

    suspend fun insertMarcadores(marcadores : List<MarcadorEntity>){
        marcadorDao.insertGame(marcadores)
    }

    suspend fun insertNacionalidades(paises : List<NacionalidadEntity>){
        nacionalidadDao.insertNacionalidad(paises)
    }

}