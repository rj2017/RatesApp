package com.example.ratesapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ratesapp.services.constants.RatesConstants
import com.example.ratesapp.services.model.HeaderModel
import com.example.ratesapp.services.repository.local.SecurityPreferences

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val mPreferences = SecurityPreferences(application)

    private val mLogout = MutableLiveData<Boolean>()
    val logout: LiveData<Boolean> = mLogout

    private val mUserInfor = MutableLiveData<HeaderModel>()
    val userInfor: LiveData<HeaderModel> = mUserInfor

    fun logout(){
        mPreferences.remove(RatesConstants.SHARED.ID)
        mPreferences.remove(RatesConstants.SHARED.NAME)
        mPreferences.remove(RatesConstants.SHARED.EMAIL)
        mLogout.value = true
    }

    fun loadUserName(){
        val nome = mPreferences.getString(RatesConstants.SHARED.NAME)
        val email = mPreferences.getString(RatesConstants.SHARED.EMAIL)
        mUserInfor.value = HeaderModel(nome,email)
    }
}