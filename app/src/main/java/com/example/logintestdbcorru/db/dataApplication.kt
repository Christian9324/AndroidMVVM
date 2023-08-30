package com.example.logintestdbcorru.db

import android.app.Application
import com.example.logintestdbcorru.retro.PaisesClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class dataApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { AppRoomDatabase.getDatabase(this, applicationScope) }

//    val network by lazy { PaisesClient }

    val repository by lazy { AppRepository(database.marcadorDao(), database.nacionalidadDao()) }
}