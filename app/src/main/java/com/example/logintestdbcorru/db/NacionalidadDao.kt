package com.example.logintestdbcorru.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NacionalidadDao {

    @Query("SELECT * FROM tabla_paises ORDER BY paises ASC")
    fun getAllPaises() : Flow<List<NacionalidadEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNacionalidad(nacionalidadEntity: List<NacionalidadEntity>)

    @Query("DELETE FROM tabla_paises")
    fun deleteAll()
}