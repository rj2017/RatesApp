package com.example.ratesapp.services.repository.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ratesapp.services.model.UserLocalModel

@Dao
interface UserDao {
    @Insert
    fun save(user : UserLocalModel) : Long

    @Query("DELETE FROM user")
    fun clear()

    @Query("SELECT * FROM user WHERE id = :id")
    fun getId(id: Int): UserLocalModel

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    fun login(email : String, password: String) : UserLocalModel
}