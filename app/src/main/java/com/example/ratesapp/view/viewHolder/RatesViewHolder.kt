package com.example.ratesapp.view.viewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ratesapp.R

class RatesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    private var mTextNome: TextView = itemView.findViewById(R.id.row_txt_cambio)
    private var mTextValor: TextView = itemView.findViewById(R.id.row_txt_valor)

    fun bindData(rates : Pair<String,Float>){
        val(nome, valor) = rates
        this.mTextNome.text = "$nome:"
        this.mTextValor.text = valor.toString()
    }
}