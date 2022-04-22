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
        Phrases("Preza por metodologias ageis, mesmo nunca tendo participado de um projeto em equipe fora da faculdade.", happy),
        Phrases("Busca aprender observando e repetindo e repetindo e reptindo e repetindo...", happy),
        Phrases("Adora aprender formas de otimizar o codigo quando se trata de desenvolvimento mobile.", happy),
        Phrases("Adoraria estar numa equipe disposta a guiar nos estudos e criações do projeto", happy),
        Phrases("Pai de dois gatos e dois cachorros", happy),
        Phrases("Adepto a ideia do trabalho home office quando não necessário encontros pessoais", happy),
        Phrases("Pai de 4 pets mas certamente com uma filha gata preferida entre eles", happy),
        Phrases("Busca pratica profissional baseado nos estudos pessoais e compreensão da equipe para guiar onde estiver perdido", happy),
        Phrases("Sair da zona de conforto é algo que se busca para um bom crescimento profissional", happy),
        Phrases("Deu uma pausa em Modelagem 3D para jogos e impressões, buscando iniciar no mercado de trabalho estagiando na area", happy),
        Phrases("Arte 3D, pedalar, jogar jogos de tabuleiro, passear com o dog e lazeres bairristas sao seus hobbies prediletos", happy),
        Phrases("Recycle view", sun),
        Phrases("Busca pensar, pesquisar e codar com tranquilidade para aplicar soluções ideais de acordo com o problema encontrado", sun),
        Phrases("", sun),
        Phrases("Pouca pratica, mas sempre buscando tornar isso uma tarefa cada vez mais presente no dia a dia", sun),
    )

    fun getPhrase(value: Int): String {
        val filtro = mListPhrases.filter { it -> (it.categoria == value) || value == all }
        val randomizacao = filtro.size.randomizacao()
        return filtro[randomizacao].descricao
    }

}

