package com.example.ratesapp.view.viewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ratesapp.R
import com.example.ratesapp.services.model.HistoricoLocalModel
import java.text.DecimalFormat

class HistoricoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var mTextbase: TextView = itemView.findViewById(R.id.text_historico_base)
    private var mTextReferencia: TextView = itemView.findViewById(R.id.text_historico_referencia)
    private var mValorBase: TextView = itemView.findViewById(R.id.valor_historico_base)
    private var mValorReferencia: TextView = itemView.findViewById(R.id.valor_historico_referencia)
    private var mData : TextView = itemView.findViewById(R.id.text_historico_data)

    fun bindData(historico : HistoricoLocalModel){

        val dec = DecimalFormat("##,##0.00")

        this.mData.text = historico.dataSalva
        this.mTextbase.text = "${historico.base} : "
        this.mValorBase.text = "${dec.format(historico.valorBase)} - "
        this.mTextReferencia.text = "${historico.referencia} : "
        this.mValorReferencia.text = "${dec.format(historico.valorTotal)}"
    }

}