package com.example.ratesapp.services.listener

interface APIListener<T> {
    fun onSucess(result: T , statusCode : Int)
    fun onFailure(message: String)
}