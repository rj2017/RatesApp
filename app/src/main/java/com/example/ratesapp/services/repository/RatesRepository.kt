package com.example.ratesapp.services.repository

import android.content.Context
import com.example.ratesapp.R
import com.example.ratesapp.services.repository.remote.IRatesService
import com.example.ratesapp.services.repository.remote.RetrofitClient
import com.example.ratesapp.services.listener.APIListener
import com.example.ratesapp.services.model.ResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RatesRepository(context: Context) : BaseRepository(context) {

    private val mRemote = RetrofitClient.createService(IRatesService::class.java)

    fun latestGetBase(valorBase : String, listener : APIListener<ResponseModel>){

        if (!isConnectionAvailable(mContext)) {
            listener.onFailure(mContext.getString(R.string.ERROR_INTERNET_CONNECTION))
            return
        }

        val call : Call<ResponseModel> = mRemote.rateGetBase(valorBase)
        call.enqueue(object : Callback<ResponseModel>{
            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                listener.onFailure(mContext.getString(R.string.ERROR_UNEXPECTED))
            }

            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                val code =  response.code()
                if (fail(code)) {
                    listener.onFailure(failRespose(response.errorBody()!!.string()))
                } else {
                    response.body()?.let { listener.onSucess(it,code) }
                }
            }

        })

    }


}