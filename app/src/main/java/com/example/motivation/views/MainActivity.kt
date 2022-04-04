package com.example.motivation.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivation.R
import com.example.motivation.mock.Mock
import com.example.motivation.util.MotivationConstants
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
        selectFilter(R.id.imageRandom)
        resetarFrase()
    }

    private var mfilter: Int = MotivationConstants.Phrase_filter.all

    private val mMock = Mock()

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
        textPhase.text = mMock.getPhrase(mfilter)
    }

    private fun selectFilter(id: Int) {

        imageHappy.setImageResource(R.drawable.ic_happy)
        imageRandom.setImageResource(R.drawable.ic_random)
        imageSun.setImageResource(R.drawable.ic_sun)

        if (id == R.id.imageSun) {
            mfilter = MotivationConstants.Phrase_filter.sun
            imageSun.setImageResource(R.drawable.ic_sun_selected)
        } else if (id == R.id.imageHappy) {
            mfilter = MotivationConstants.Phrase_filter.happy
            imageHappy.setImageResource(R.drawable.ic_happy_selected)
        } else {
            mfilter = MotivationConstants.Phrase_filter.all
            imageRandom.setImageResource(R.drawable.ic_random_selected)
        }
    }
}