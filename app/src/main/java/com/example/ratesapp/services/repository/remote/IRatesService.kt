package com.example.ratesapp.services.repository.remote

import com.example.ratesapp.services.model.ResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.Path
import retrofit2.http.Query

interface IRatesService {

    @GET("latest")
    fun latest() : Call<ResponseModel>

    @HTTP(method = "GET",path = "latest",hasBody = false)
    fun rateGetBase(@Query("base") base : String) : Call<ResponseModel>


}