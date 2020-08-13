package com.example.ratesapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ratesapp.services.listener.APIListener
import com.example.ratesapp.services.listener.ValidationListener
import com.example.ratesapp.services.model.ResponseModel
import com.example.ratesapp.services.repository.RatesRepository
import java.util.*

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository = RatesRepository(application)

    private var mList = MutableLiveData<List<Pair<String,Float>>>()
    val list : LiveData<List<Pair<String,Float>>> = mList

    private val mValidation = MutableLiveData<ValidationListener>()
    val validation: LiveData<ValidationListener> = mValidation

    fun listar(base : String){
        mRepository.latestGetBase(base, object : APIListener<ResponseModel>{
            override fun onSucess(result: ResponseModel, statusCode: Int) {
                val list  = result.rates.toList()
                mList.value = list
            }

            override fun onFailure(message: String) {
                mValidation.value = ValidationListener(message)
            }
        })
    }
}