package com.example.ratesapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ratesapp.services.constants.RatesConstants
import com.example.ratesapp.services.model.HeaderModel
import com.example.ratesapp.services.repository.UserRepository
import com.example.ratesapp.services.repository.local.SecurityPreferences

class PerfilViewModel(application: Application) : AndroidViewModel(application) {

    private val mPreferences = SecurityPreferences(application)
    private val mRepository : UserRepository = UserRepository(application)

    private val mUserInfor = MutableLiveData<HeaderModel>()
    val userInfor: LiveData<HeaderModel> = mUserInfor

    private val mIsAlterado = MutableLiveData<Boolean>()
    val isAlterado: LiveData<Boolean> = mIsAlterado

    fun loadDados(){
        val nome = mPreferences.getString(RatesConstants.SHARED.NAME)
        val email = mPreferences.getString(RatesConstants.SHARED.EMAIL)
        mUserInfor.value = HeaderModel(nome,email)
    }

    fun alterarDadosUsuario(nome : String, email : String){
        val id = mPreferences.get(RatesConstants.SHARED.ID)

        if (nome != mPreferences.getString(RatesConstants.SHARED.NAME) || email != mPreferences.getString(RatesConstants.SHARED.EMAIL)){
            val user = mRepository.alterar(id,nome,email)
             mPreferences.store(RatesConstants.SHARED.NAME, user.nome)
             mPreferences.store(RatesConstants.SHARED.EMAIL,user.email)
             mIsAlterado.value = true
         }else{
             mIsAlterado.value =false
         }
    }
}