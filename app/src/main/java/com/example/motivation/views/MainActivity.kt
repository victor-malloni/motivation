package com.example.motivation.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.motivation.R
import com.example.motivation.mock.Mock
import com.example.motivation.util.MotivationConstants
import com.example.motivation.util.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*


import android.net.Uri
import android.util.TypedValue
import androidx.annotation.Px
import androidx.core.widget.TextViewCompat
import kotlinx.android.synthetic.main.activity_splash.*
import java.security.Security

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var mFilter: Int = MotivationConstants.Phrase_filter.all
    private lateinit var mSecurityPreferences: SecurityPreferences
    private val mMock = Mock()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mSecurityPreferences = SecurityPreferences(this)

        //eventos
        setListeners()

        //inicializar
        selectFilter(R.id.imageRandom)
        resetarFrase()
        verifyUserName()

       // TextViewCompat.setAutoSizeTextTypeWithDefaults(textPhase, TypedValue.COMPLEX_UNIT_PX)

        //botao link curriculo
      /*  btnLinkCurriculo.setOnClickListener(){
            val openUrl = Intent(android.content.Intent.ACTION_VIEW)
            val url = getString(R.string.hyperlink)
            openUrl.data=Uri.parse("$url")
            startActivity(openUrl)
        }*/
    }




    override fun onClick(view: View) {
        var listaId = listOf(R.id.imageHappy, R.id.imageSun, R.id.imageRandom)
        val id = view.id
        if (id in listaId) {
            selectFilter(id)
        } else if (id == R.id.btnNewPhase) {
            resetarFrase()
        }
    }


    private fun setListeners() {
        imageRandom.setOnClickListener(this)
        imageHappy.setOnClickListener(this)
        imageSun.setOnClickListener(this)
        btnNewPhase.setOnClickListener(this)

    }


    private fun resetarFrase() {
        textPhase.text = mMock.getPhrase(mFilter)
    }

    private fun selectFilter(id: Int) {
        imageHappy.setImageResource(R.drawable.ic_happy)
        imageRandom.setImageResource(R.drawable.ic_random)
        imageSun.setImageResource(R.drawable.ic_sun)

        if (id == R.id.imageSun) {
            mFilter = MotivationConstants.Phrase_filter.sun
            imageSun.setImageResource(R.drawable.ic_sun_selected)
        } else if (id == R.id.imageHappy) {
            mFilter = MotivationConstants.Phrase_filter.happy
            imageHappy.setImageResource(R.drawable.ic_happy_selected)
        } else {
            mFilter = MotivationConstants.Phrase_filter.all
            imageRandom.setImageResource(R.drawable.ic_random_selected)
        }
        verifyUserName()
    }

    private fun verifyUserName(){
        val name = mSecurityPreferences.getStoredString(MotivationConstants.KEY.PERSON_NAME)
        //textUserName.text="Olá, $name!"
        val opcoes = mFilter

        if (opcoes==1){
            textUserName.text="$name, es a questão:"
        } else if(opcoes==2){
            textUserName.text="Elementar meu caso Wats... ops, $name!"
        } else
            textUserName.text="Reflexões, apenas reflexões, $name."
    }
}