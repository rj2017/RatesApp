package com.example.ratesapp.services.model

import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.HashMap

class ResponseModel {

    @SerializedName("rates")
    val rates : Map<String,Float> = HashMap()


    @SerializedName("base")
    val base : String = ""

    @SerializedName("date")
    val date : Date = Date()
}