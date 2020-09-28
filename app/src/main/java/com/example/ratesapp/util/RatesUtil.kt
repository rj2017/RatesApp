package com.example.ratesapp.util

import com.example.ratesapp.R

class RatesUtil {

    companion object {
        fun getNomeMoeda(sigla: String): String {
            var nome: String = ""
            when (sigla) {
                "BRL" -> nome = "Real Brasileiro"
                "EUR" -> nome = "Euro"
                "USD" -> nome = "Dóla EUA"
                "CAD" -> nome = "Dóla Canadense"
                "HKD" -> nome = "Dólar de Hong Kong"
                "ISK" -> nome = "Coroa islandesa"
                "PHP" -> nome = "Peso filipino"
                "DKK" -> nome = "Coroa dinamarquesa"
                "HUF" -> nome = "Florim húngaro"
                "CZK" -> nome = "Coroa checa"
                "GBP" -> nome = "Libra esterlina"
                "RON" -> nome = "Moeda da Romênia"
                "SEK" -> nome = "Coroa sueca"
                "IDR" -> nome = "Rupiah"
                "INR" -> nome = "Rupia indiana"
                "HRK" -> nome = "Kuna"
                "JPY" -> nome = "Yen"
                "RUB" -> nome = "Rublo Russo"
                "NOK" -> nome = "Coroa Norueguesa"
                "THB" -> nome = "Baht"
                "CHF" -> nome = "Franco suíço"
                "MYR" -> nome = "Ringgit da Malásia"
                "BGN" -> nome = "Lev búlgaro"
                "TRY" -> nome = "Lira turca"
                "CNY" -> nome = "Ren-Min-Bi, Yuan"
                "NZD" -> nome = "Dólar neozelandês"
                "ZAR" -> nome = "Rand"
                "MXN" -> nome = "Peso mexicano"
                "SGD" -> nome = "Dólar de Cingapura"
                "AUD" -> nome = "Dólar australiano"
                "ILS" -> nome = "shekel israelita"
                "KRW" -> nome = "Won sul-coreano"
                "PLN" -> nome = "Zloty"
            }
            return nome
        }

        fun getImageMoeda(sigla: String): Int {
            var image: Int = 0
            when (sigla) {
                "BRL" -> image = R.drawable.brasil
                "EUR" -> image = R.drawable.europa
                "USD" -> image = R.drawable.eua
                "CAD" -> image = R.drawable.canada
                "HKD" -> image = R.drawable.hong_kong
                "ISK" -> image = R.drawable.islandia
                "PHP" -> image = R.drawable.filipinas
                "DKK" -> image = R.drawable.dinamarca
                "HUF" -> image = R.drawable.hungria
                "CZK" -> image = R.drawable.republica_checa
                "GBP" -> image = R.drawable.reino_unido
                "RON" -> image = R.drawable.romenia
                "SEK" -> image = R.drawable.suecia
                "IDR" -> image = R.drawable.indonesia
                "INR" -> image = R.drawable.india
                "HRK" -> image = R.drawable.croacia
                "JPY" -> image = R.drawable.japao
                "RUB" -> image = R.drawable.russia
                "NOK" -> image = R.drawable.noruega
                "THB" -> image = R.drawable.tailandia
                "CHF" -> image = R.drawable.suica
                "MYR" -> image = R.drawable.malasia
                "BGN" -> image = R.drawable.bulgaria
                "TRY" -> image = R.drawable.turquia
                "CNY" -> image = R.drawable.china
                "NZD" -> image = R.drawable.nova_zelandia
                "ZAR" -> image = R.drawable.africa_do_sul
                "MXN" -> image = R.drawable.mexico
                "SGD" -> image = R.drawable.cingapura
                "AUD" -> image = R.drawable.australia
                "ILS" -> image = R.drawable.israel
                "KRW" -> image = R.drawable.coreia_sul
                "PLN" -> image = R.drawable.polonia
            }
            return image
        }

        fun getCodigoPorNome(nome: String): String {
            var sigla: String = ""
            when (nome) {
                "Real Brasileiro"  -> sigla = "BRL"
                "Euro"  -> sigla = "EUR"
                "Dóla EUA"  -> sigla = "USD"
                "Dóla Canadense"  -> sigla = "CAD"
                "Dólar de Hong Kong"  -> sigla = "HKD"
                "Coroa islandesa"  -> sigla = "ISK"
                "Peso filipino"  -> sigla = "PHP"
                "Coroa dinamarquesa"  -> sigla = "DKK"
                "Florim húngaro"  -> sigla = "HUF"
                "Coroa checa"  -> sigla = "CZK"
                "Libra esterlina"  -> sigla = "GBP"
                "Moeda da Romênia"  -> sigla = "RON"
                "Coroa sueca"  -> sigla = "SEK"
                "Rupiah"  -> sigla = "IDR"
                "Rupia indiana"  -> sigla = "INR"
                "Kuna"  -> sigla = "HRK"
                "Yen"  -> sigla = "JPY"
                "Rublo Russo"  -> sigla = "RUB"
                "Coroa Norueguesa"  -> sigla = "NOK"
                "Baht"  -> sigla = "THB"
                "Franco suíço"  -> sigla = "CHF"
                "Ringgit da Malásia"  -> sigla = "MYR"
                "Lev búlgaro"  -> sigla = "BGN"
                "Lira turca"  -> sigla = "TRY"
                "Ren-Min-Bi, Yuan"  -> sigla = "CNY"
                "Dólar neozelandês"  -> sigla = "NZD"
                "Rand"  -> sigla = "ZAR"
                "Peso mexicano"  -> sigla = "MXN"
                "Dólar de Cingapura"  -> sigla = "SGD"
                "Dólar australiano"  -> sigla = "AUD"
                "shekel israelita"  -> sigla = "ILS"
                "Won sul-coreano"  -> sigla = "KRW"
                "Zloty"  -> sigla = "PLN"
            }
            return sigla
        }
    }
}
