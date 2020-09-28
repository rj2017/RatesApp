package com.example.ratesapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ratesapp.services.constants.RatesConstants
import com.example.ratesapp.services.listener.APIListener
import com.example.ratesapp.services.model.HistoricoLocalModel
import com.example.ratesapp.services.model.ResponseModel
import com.example.ratesapp.services.repository.HistoricoRepository
import com.example.ratesapp.services.repository.RatesRepository
import com.example.ratesapp.services.repository.local.SecurityPreferences
import java.util.*

class ConversaoViewModel(application : Application) : AndroidViewModel(application) {

    private val mRepository = RatesRepository(application)
    private val mLocalRepository = HistoricoRepository(application)
    private val mSecurityPreferences = SecurityPreferences(application)

    private val mResultado = MutableLiveData<Float>()
    val resultado : LiveData<Float> = mResultado

    fun converter(base: String, referencia: String, valor: Float, data: String){
        mRepository.latestGetBase(base, object : APIListener<ResponseModel>{
            override fun onSucess(result: ResponseModel, statusCode: Int) {
                val valorMoeda = result.rates[referencia]
                val resultado = valor * valorMoeda!!

                val historico = HistoricoLocalModel()
                historico.base = base
                historico.referencia = referencia
                historico.userId = mSecurityPreferences.get(RatesConstants.SHARED.ID)
                historico.valorBase = valor
                historico.valorTotal = resultado
                historico.dataSalva =data

                salvarHistorico(historico)
                mResultado.value = resultado

            }

            override fun onFailure(message: String) {
                mResultado.value = null
            }

        })
    }

    private fun salvarHistorico(historico: HistoricoLocalModel){
        mLocalRepository.save(historico)
    }

}