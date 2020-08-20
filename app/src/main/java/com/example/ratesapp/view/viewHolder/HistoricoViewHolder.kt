package com.example.ratesapp.view.viewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ratesapp.R
import com.example.ratesapp.services.model.HistoricoLocalModel
class HistoricoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var mTextbase: TextView = itemView.findViewById(R.id.text_historico_base)
    private var mTextReferencia: TextView = itemView.findViewById(R.id.text_historico_referencia)
    private var mValorBase: TextView = itemView.findViewById(R.id.valor_historico_base)
    private var mValorReferencia: TextView = itemView.findViewById(R.id.valor_historico_referencia)

    fun bindData(historico : HistoricoLocalModel){
        this.mTextbase.text = "${historico.base} : "
        this.mValorBase.text = "${historico.valorBase.toString().replace(".",",")} - "
        this.mTextReferencia.text = "${historico.referencia} :"
        this.mValorReferencia.text = "${historico.valorTotal.toString().replace(".",",")}"
    }

}