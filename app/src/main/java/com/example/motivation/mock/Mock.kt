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

        Phrases("Um profissional não é alguém que se sacrifica por seu trabalho. Isso é um louco.\n -Reno (Final Fantasy)", happy),
        Phrases("A perfeição absoluta será a sua maior fraqueza. Na imperfeição é a essência do ser humano.\n –Vicent Valentine (Final Fantasy)", happy),
        Phrases("Quem precisa não escolhe.\n -Tess (The last of us)", happy),
        Phrases("Não adianta ser inteligente se você não tornar o mundo melhor.\n -Elisabet (Horizon Zero Dawn)", happy),
        Phrases("Treinar na solidão serve apenas para perpetuar erros.\n – Vesemir (The Witcher)", happy),

        Phrases("A esperança é o que nos fortalece! É por ela que estamos aqui! É por ela que lutamos quando todo o resto está perdido!\n -Pandora (God of War)", sun),
        Phrases("Lembre-se de que o excesso de confiança é um assassino lento e insidioso.\n -Narrador (Darkest Dungeon)", sun),
        Phrases("Palavras não são o único modo de dizer a alguém como você se sente.\n -Tifa (Final Fantasy)", sun),
        Phrases("Se estiverem esperando que eu desista, é bom esperarem sentados.\n -Poppy (League of Legends)", sun),
        Phrases("Metas comuns estabelecem parcerias impossíveis.\n -Yennefer (The Witcher)", sun))

    fun getPhrase(value: Int): String {
        val filtro = mListPhrases.filter { it -> (it.categoria == value) || value == all }
        val randomizacao = filtro.size.randomizacao()
        return filtro[randomizacao].descricao
    }


}

