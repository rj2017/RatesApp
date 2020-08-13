package com.example.ratesapp.services.repository

import android.content.Context
import com.example.ratesapp.services.model.UserLocalModel
import com.example.ratesapp.services.repository.local.RatesDatabase
import java.lang.Exception

class UserRepository(context: Context){

    private val mDatabase = RatesDatabase.getDatabase(context).userDao()

    fun save(user: UserLocalModel) : Boolean{
        return mDatabase.save(user) > 0
    }

    fun logar(email: String, password : String): UserLocalModel{
        return mDatabase.login(email,password)
    }
}