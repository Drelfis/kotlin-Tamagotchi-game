package com.example.imadtask2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Continue Button
        val txtContinue = findViewById<TextView>(R.id.txtContinue)
        val btnContinue = findViewById<Button>(R.id.btnScreen)
        startFlashAnimation(txtContinue)

        btnContinue.setOnClickListener{
            //Switching to Game Screen
            val intent = Intent(this@HomeScreen, GameScreen::class.java)
            startActivity(intent)
        }



    }

    fun startFlashAnimation(view: View) { //<----- making button flash
        val flashAnimation = AnimationUtils.loadAnimation(this, R.anim.flash_text)
        view.startAnimation(flashAnimation)
    }

}