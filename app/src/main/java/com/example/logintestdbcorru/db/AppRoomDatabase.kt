package com.example.logintestdbcorru.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(
    entities = arrayOf(
        NacionalidadEntity::class,
        MarcadorEntity::class,
    ),
    version = 1,
    exportSchema = false
)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun nacionalidadDao(): NacionalidadDao
    abstract fun marcadorDao(): MarcadorDao

    private class appCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let{ database ->
                scope.launch {
                    var nacionalidadDao = database.nacionalidadDao()
                    var marcadorDao = database.marcadorDao()

                    nacionalidadDao.deleteAll()
                    marcadorDao.deleteAll()
                }
            }
        }
    }

    companion object{
        @Volatile
        private var INSTANCE : AppRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope,
        ) : AppRoomDatabase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppRoomDatabase::class.java,
                    "nacionalidad_database",
                ).addCallback(appCallback(scope)).build()
                INSTANCE = instance
                instance
            }
        }
    }
}