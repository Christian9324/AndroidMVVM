package com.example.logintestdbcorru.model

class QuoteProvider {

    companion object {

        var quotes : List<QuoteModel> = emptyList()

//        private val quote = listOf<QuoteModel>(
//            QuoteModel(
//                "La conciencia es una sombra intentando alumbrarse.",
//                "Cantar y coser, Shariff"
//            ),
//            QuoteModel(
//                "Tarde aprendí que el amor dura un minuto \n" +
//                        "Y el resto de la vida te lo pasas esperando.",
//                "El callejón de los milagros, sharif"
//            ),
//            QuoteModel(
//                "Vendí tanto mi alma que ya no vale nada.",
//                "Noko, Molotov"
//            ),
//            QuoteModel(
//                "Pero como suele suceder que la excesiva prosperidad es precisamente el camino que lleva a las mayores de las adversidades, así sucedió conmigo",
//                "Robinson Crusoe, Daniel Dafoe"
//            ),
//            QuoteModel(
//                "He aprendido que no puedo exigir el amor de nadie.\n Yo sólo puedo dar buenas razones para ser querido...\nY tener paciencia para que la vida haga el resto",
//                "William S."
//            ),
//            QuoteModel(
//                "Fuiste la forma más triste y bonita que tuvo la vida de decirme que no se puede tenerlo todo",
//                "Anonimo"
//            ),
//            QuoteModel(
//                "8 Billones de Sonrisas y la tuya es mi favorita",
//                "Aninimo"
//            ),
//        )
//
        fun randomQuote() : QuoteModel{
//            val position : Int =  (0..quotes.size - 1).random()
            val position : Int =  (quotes.indices).random()
            return quotes[position]
        }
    }
}