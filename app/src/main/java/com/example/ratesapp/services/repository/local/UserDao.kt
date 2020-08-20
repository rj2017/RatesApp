package com.example.ratesapp.services.repository.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
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

    @Query("UPDATE user SET 'nome' = :nome , 'email' = :email WHERE id = :id")
    fun alterar(id: Int, nome : String, email : String) : Int

    @Query("UPDATE user SET 'password' = :senha WHERE id = :id AND password = :senha")
    fun alterarSenha(id: Int, senha: String) : Int
}