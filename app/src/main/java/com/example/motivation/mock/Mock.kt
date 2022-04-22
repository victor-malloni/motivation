package com.example.motivation.mock

import android.content.Intent
import android.net.Uri
import com.example.motivation.R
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

        Phrases("Lorem Ipsum is simply dummy text of the", happy),
       // Phrases("Lorem Ipsum is simply dummy text of theLorem Ipsum is simply dummy text of the", happy),
        Phrases("Lorem ItLorem Ipsum is simply dummy text of theLorem Ipsum is simply dummy text of theLorem Ipsum is simply dummy text of theLorem Ipsum is simply dummy text of theLorem Ipsum is simply dummy text omy text of theexthe", sun),
       // Phrases("Lorem Ipsum is simply dummy text of theLorem Ipsum is simply dummy text of theLorem Ipsum is simply dummy text of theLorem Ipsum is simply dummy text of the", sun)
    )

    fun getPhrase(value: Int): String {
        val filtro = mListPhrases.filter { it -> (it.categoria == value) || value == all }
        val randomizacao = filtro.size.randomizacao()
        return filtro[randomizacao].descricao
    }


}

