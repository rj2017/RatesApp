package com.example.ratesapp.services.repository

import android.content.Context
import com.example.ratesapp.services.model.HistoricoLocalModel
import com.example.ratesapp.services.repository.local.RatesDatabase

class HistoricoRepository(context: Context) {

    private val mDatabase = RatesDatabase.getDatabase(context).historicoDao()

    fun save(historico : HistoricoLocalModel) {
        mDatabase.save(historico)
    }

    fun selectAll(id : Int): List<HistoricoLocalModel>{
        return mDatabase.selectAll(id)
    }
}