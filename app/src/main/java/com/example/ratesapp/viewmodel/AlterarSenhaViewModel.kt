package com.example.ratesapp.viewmodel

import android.app.Application
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ratesapp.services.constants.RatesConstants
import com.example.ratesapp.services.repository.UserRepository
import com.example.ratesapp.services.repository.local.SecurityPreferences

class AlterarSenhaViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository = UserRepository(application)
    private val mPreferences = SecurityPreferences(application)

    private var mIsAlterado = MutableLiveData<Boolean>()
    var isAlterado : LiveData<Boolean> = mIsAlterado

    fun alterarSenha(senha: String){
        val id = mPreferences.get(RatesConstants.SHARED.ID)

        if (mRepository.alterarSenha(id,senha)){
            mIsAlterado.value =true
        }else{
            mIsAlterado.value = false
        }
    }
}