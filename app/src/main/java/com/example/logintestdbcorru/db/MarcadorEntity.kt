package com.example.logintestdbcorru.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game")
data class MarcadorEntity(
    @PrimaryKey
    val id: Long,
    val date : String,
    val teamL : String,
    val teamV : String,
    val scoreL : Int,
    val scoreV : Int,
)
