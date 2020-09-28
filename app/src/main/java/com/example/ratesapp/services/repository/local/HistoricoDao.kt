package com.example.ratesapp.services.repository.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ratesapp.services.model.HistoricoLocalModel

@Dao
interface HistoricoDao {

    @Insert
    fun save(historico : HistoricoLocalModel) : Long

    @Query("SELECT * FROM historico WHERE userid = :id")
    fun selectAll(id: Int) : List<HistoricoLocalModel>

}