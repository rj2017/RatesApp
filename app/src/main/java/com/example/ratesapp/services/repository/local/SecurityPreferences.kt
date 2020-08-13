package com.example.ratesapp.services.repository.local

import android.content.Context
import android.content.SharedPreferences

/**
 * Acesso a dados rápidos do projeto - SharedPreferences
 */

class SecurityPreferences(context: Context) {
    private val mPreferences: SharedPreferences =
        context.getSharedPreferences("taskShared", Context.MODE_PRIVATE)

    fun store(key: String, value: String) {
        mPreferences.edit().putString(key, value).apply()
    }

    fun store(key: String, value: Int) {
        mPreferences.edit().putInt(key, value).apply()
    }

    fun remove(key: String) {
        mPreferences.edit().remove(key).apply()
    }

    fun get(key: String): Int {
        return mPreferences.getInt(key,0) ?: 0
    }

    fun getString(key: String): String {
        return mPreferences.getString(key,"") ?: ""
    }
}