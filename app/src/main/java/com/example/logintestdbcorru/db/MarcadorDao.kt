package com.example.logintestdbcorru.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MarcadorDao {

    @Query("SELECT * FROM game ORDER BY date ASC")
    fun getAllScores() : Flow<List<MarcadorEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGame(marcadorEntity: List<MarcadorEntity>)

    @Query("DELETE FROM game")
    fun deleteAll()

}