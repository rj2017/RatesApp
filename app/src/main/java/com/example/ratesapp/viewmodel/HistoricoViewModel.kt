package com.example.ratesapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ratesapp.services.constants.RatesConstants
import com.example.ratesapp.services.model.HistoricoLocalModel
import com.example.ratesapp.services.repository.HistoricoRepository
import com.example.ratesapp.services.repository.local.SecurityPreferences

class HistoricoViewModel(application: Application) : AndroidViewModel(application) {

    private val mLocalRepository =  HistoricoRepository(application)
    private val mSecurityPreferences = SecurityPreferences(application)

    private val mList = MutableLiveData<List<HistoricoLocalModel>>()
    val List : LiveData<List<HistoricoLocalModel>> = mList

    fun listarHistorico(){

        val id = mSecurityPreferences.get(RatesConstants.SHARED.ID)
        val listaHistorico = mLocalRepository.selectAll(id)

        if (listaHistorico.isNotEmpty()){
            mList.value = listaHistorico
        }
    }
}