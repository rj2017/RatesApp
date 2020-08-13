package com.example.ratesapp.view.viewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ratesapp.R
import com.example.ratesapp.services.model.HistoricoLocalModel

class HistoricoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var mTextbase: TextView = itemView.findViewById(R.id.text_historico_base)
    private var mTextReferencia: TextView = itemView.findViewById(R.id.text_historico_referencia)

    fun bindData(historico : HistoricoLocalModel){
        this.mTextbase.text = "${historico.base} : ${historico.valorBase} - "
        this.mTextReferencia.text = "${historico.referencia} : ${historico.valorTotal}"
    }

}