package com.example.ratesapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ratesapp.services.constants.RatesConstants
import com.example.ratesapp.services.repository.local.SecurityPreferences

class SplashViewModel(application: Application) : AndroidViewModel(application){

    private val mSecurityPreferences = SecurityPreferences(application)

    private val mLogado = MutableLiveData<Boolean>()
    val logado : LiveData<Boolean> = mLogado

    fun isLogado(){
        val idUser = mSecurityPreferences.get(RatesConstants.SHARED.ID)
        val name = mSecurityPreferences.getString(RatesConstants.SHARED.NAME)
        val email = mSecurityPreferences.getString(RatesConstants.SHARED.EMAIL)

        val loged = (idUser > 0 || name != "" || email != "")

        mLogado.value = loged
    }
}