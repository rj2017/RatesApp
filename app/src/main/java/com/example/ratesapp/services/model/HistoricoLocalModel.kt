package com.example.ratesapp.services.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(tableName = "historico")
class HistoricoLocalModel {

    @SerializedName("id")
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id :Int = 0

    @SerializedName("userid")
    @ColumnInfo(name = "userid")
    var userId : Int = 0

    @SerializedName("base")
    @ColumnInfo(name = "base")
    lateinit var base : String

    @SerializedName("referencia")
    @ColumnInfo(name = "referencia")
    lateinit var referencia : String

    @SerializedName("valorbase")
    @ColumnInfo(name = "valorbase")
    var valorBase : Float = 0F

    @SerializedName("valortotal")
    @ColumnInfo(name = "valortotal")
    var valorTotal : Float = 0F

}