package com.example.ratesapp.services.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ratesapp.services.model.HistoricoLocalModel
import com.example.ratesapp.services.model.UserLocalModel

@Database(entities = [UserLocalModel::class, HistoricoLocalModel::class],version = 1)
abstract class RatesDatabase : RoomDatabase() {

    abstract fun userDao() : UserDao
    abstract fun historicoDao() : HistoricoDao

    companion object {
        private lateinit var INSTANCE: RatesDatabase

        fun getDatabase(context: Context): RatesDatabase {
            if (!Companion::INSTANCE.isInitialized) {
                synchronized(RatesDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context, RatesDatabase::class.java, "RatesDB")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}