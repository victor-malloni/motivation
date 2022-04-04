package com.example.motivation.mock

import java.util.*
import com.example.motivation.util.MotivationConstants
import kotlin.random.Random as Random

class Phrases(val descricao: String, val categoria: Int)

fun Int.randomizacao(): Int {
    return java.util.Random().nextInt(this)
}

class Mock {
    private val all = MotivationConstants.Phrase_filter.all
    private val sun = MotivationConstants.Phrase_filter.sun
    private val happy = MotivationConstants.Phrase_filter.happy


    private val mListPhrases: List<Phrases> = listOf(
        Phrases("frase feliz 1", happy),
        Phrases("frase feliz 1", happy),
        Phrases("frase feliz 2", happy),
        Phrases("frase feliz 3", happy),
        Phrases("frase manha 1", sun),
        Phrases("frase manha 2", sun),
        Phrases("frase manha 3", sun),
        Phrases("frase manha 4", sun),
    )

    fun getPhrase(value: Int): String {
        val filtro = mListPhrases.filter { it -> (it.categoria == value) || value == all }

        val randomizacao = filtro.size.randomizacao()

        return filtro[randomizacao].descricao

    }

}

