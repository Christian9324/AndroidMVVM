package com.example.logintestdbcorru.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_paises")
data class NacionalidadEntity(
    @PrimaryKey
    val paises : String
)
