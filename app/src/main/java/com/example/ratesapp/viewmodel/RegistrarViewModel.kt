package com.example.ratesapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ratesapp.services.model.UserLocalModel
import com.example.ratesapp.services.repository.UserRepository

class RegistrarViewModel(application: Application) : AndroidViewModel(application) {
    private val mRepository = UserRepository(application)

    private val mSave = MutableLiveData<Boolean>()
    val save : LiveData<Boolean> = mSave

    fun registrar(user : UserLocalModel){
        if (mRepository.save(user)){
            mSave.value = true
        }
    }
}