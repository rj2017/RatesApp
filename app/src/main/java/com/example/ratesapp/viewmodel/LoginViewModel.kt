package com.example.ratesapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ratesapp.services.constants.RatesConstants
import com.example.ratesapp.services.repository.UserRepository
import com.example.ratesapp.services.repository.local.SecurityPreferences


class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository = UserRepository(application)
    private val mSecurityPreferences = SecurityPreferences(application)

    private val mLogar = MutableLiveData<Boolean>()
    val logar : LiveData<Boolean> = mLogar

    private val mLogado = MutableLiveData<Boolean>()
    val logado : LiveData<Boolean> = mLogado

    fun logar(email :String, password : String){
        val user = mRepository.logar(email,password)

        if (user != null){
        // Salvar dados do usuário no SharePreferences
        mSecurityPreferences.store(RatesConstants.SHARED.ID, user.id)
        mSecurityPreferences.store(RatesConstants.SHARED.NAME, user.nome)
        mSecurityPreferences.store(RatesConstants.SHARED.EMAIL, user.email)

        mLogar.value = true
        }else{
            mLogar.value =false
        }

    }

    fun verifyLoggedUser(){
        val idUser = mSecurityPreferences.get(RatesConstants.SHARED.ID)
        val name = mSecurityPreferences.getString(RatesConstants.SHARED.NAME)
        val email = mSecurityPreferences.getString(RatesConstants.SHARED.EMAIL)

        val loged = (idUser > 0 || name != "" || email != "")

        mLogado.value = loged
    }

}