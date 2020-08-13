package com.example.ratesapp.services.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user")
class UserLocalModel {

    @SerializedName("id")
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @SerializedName("nome")
    @ColumnInfo(name = "nome")
    lateinit var nome: String

    @SerializedName("email")
    @ColumnInfo(name = "email")
    lateinit var email : String

    @SerializedName("password")
    @ColumnInfo(name = "password")
    lateinit var password : String
}