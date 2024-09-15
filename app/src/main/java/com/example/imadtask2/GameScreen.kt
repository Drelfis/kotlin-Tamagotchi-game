package com.example.imadtask2

import android.content.Context
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.content.SharedPreferences
import android.net.PlatformVpnProfile
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProvider

class GameScreen : AppCompatActivity() {


    var HungerScore = 20
    var WashScore = 20          //<---- default starting values
    var PlayScore = 20

    var dtLastUpdateTime: Long = 0

    private lateinit var prefs: SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onCreate()

        setContentView(R.layout.activity_game_screen)
        val btnFeed = findViewById<Button>(R.id.btnFeed)
        val btnWash = findViewById<Button>(R.id.btnWash)        //<--- Linking from screen
        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val picture = findViewById<ImageView>(R.id.imageView)




        if(SadCheck(HungerScore)){

            picture.setImageResource(R.drawable._h4dz9baia371)

        }else if(SadCheck(WashScore)){

            picture.setImageResource(R.drawable._h4dz9baia371)

        }else if (SadCheck(PlayScore)){

            picture.setImageResource(R.drawable._h4dz9baia371)

        } //Checking if Mochi is sad





        btnFeed.text = "Feed Mochi: $HungerScore"         //Display Hunger Score
        btnPlay.text = "Play With Mochi: $PlayScore"      //Display Play Score
        btnWash.text = "Wash Mochi: $WashScore"           //Display Wash Score

        btnFeed.setOnClickListener {  //<-- feed button logic

            Feed()// running feed class

            picture.setImageResource(R.drawable.giphy_gif__400_320_)

            when(ScoreCheck(HungerScore)) {

                true -> btnFeed.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.Warning))
                false -> btnFeed.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.dark_blue))

            }//<--Checking button colors
            when(ScoreCheck(PlayScore)) {

                true -> btnPlay.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.Warning))
                false -> btnPlay.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.dark_blue))

            }//<--Checking button colors
            when(ScoreCheck(WashScore)) {

                true -> btnWash.backgroundTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.Warning))

                false -> btnWash.backgroundTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.dark_blue))

            }//<--Checking button colors

            btnFeed.text = "Feed Mochi: $HungerScore"
            btnPlay.text = "Play With Mochi: $PlayScore"  //<----- Updating Buttons Text
            btnWash.text = "Wash Mochi: $WashScore"


            if(HungerScore <= 0 ){

                HungerScore = 0

                btnFeed.text = "Feed Mochi: $HungerScore"         //Display Hunger Score
                btnPlay.text = "Play With Mochi: $PlayScore"      //Display Play Score
                btnWash.text = "Wash Mochi: $WashScore"           //Display Wash Score

            }
            if (WashScore <=0){

                WashScore = 0

                btnFeed.text = "Feed Mochi: $HungerScore"         //Display Hunger Score
                btnPlay.text = "Play With Mochi: $PlayScore"      //Display Play Score
                btnWash.text = "Wash Mochi: $WashScore"           //Display Wash Score

            }
            if (PlayScore <= 0){

                PlayScore = 0

                btnFeed.text = "Feed Mochi: $HungerScore"         //Display Hunger Score
                btnPlay.text = "Play With Mochi: $PlayScore"      //Display Play Score
                btnWash.text = "Wash Mochi: $WashScore"           //Display Wash Score




            }




        }

        btnPlay.setOnClickListener {

            Play()// running play class
            picture.setImageResource(R.drawable.c5ee5152fd8575cd966fa258addca1a1)

            when(ScoreCheck(HungerScore)) {

                true -> btnFeed.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.Warning))
                false -> btnFeed.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.dark_blue))

            }//<--Checking button colors
            when(ScoreCheck(PlayScore)) {

                true -> btnPlay.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.Warning))
                false -> btnPlay.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.dark_blue))

            } //<--Checking button colors
            when(ScoreCheck(WashScore)) {

                true -> btnWash.backgroundTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.Warning))

                false -> btnWash.backgroundTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.dark_blue))

            }//<--Checking button colors

            btnFeed.text = "Feed Mochi: $HungerScore"
            btnPlay.text = "Play With Mochi: $PlayScore"  //<----- Updating Buttons Text
            btnWash.text = "Wash Mochi: $WashScore"

            if(HungerScore <= 0 ){

                HungerScore = 0

                btnFeed.text = "Feed Mochi: $HungerScore"         //Display Hunger Score
                btnPlay.text = "Play With Mochi: $PlayScore"      //Display Play Score
                btnWash.text = "Wash Mochi: $WashScore"           //Display Wash Score

            }
            if (WashScore <=0){

                WashScore = 0

                btnFeed.text = "Feed Mochi: $HungerScore"         //Display Hunger Score
                btnPlay.text = "Play With Mochi: $PlayScore"      //Display Play Score
                btnWash.text = "Wash Mochi: $WashScore"           //Display Wash Score

            }
            if (PlayScore <= 0){


                PlayScore = 0

                btnFeed.text = "Feed Mochi: $HungerScore"         //Display Hunger Score
                btnPlay.text = "Play With Mochi: $PlayScore"      //Display Play Score
                btnWash.text = "Wash Mochi: $WashScore"           //Display Wash Score



            }



        }

        btnWash.setOnClickListener {

            Wash()// running feed class
            picture.setImageResource(R.drawable._9c159ca947f88a26bb8e77ac5853eb9)

            when(ScoreCheck(HungerScore)) {

                true -> btnFeed.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.Warning))
                false -> btnFeed.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.dark_blue))

            }//<--Checking button colors
            when(ScoreCheck(PlayScore)) {

                true -> btnPlay.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.Warning))
                false -> btnPlay.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.dark_blue))

            }//<--Checking button colors
            when(ScoreCheck(WashScore)) {

                true -> btnWash.backgroundTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.Warning))

                false -> btnWash.backgroundTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.dark_blue))

            }//<--Checking button colors

            btnFeed.text = "Feed Mochi: $HungerScore"
            btnPlay.text = "Play With Mochi: $PlayScore"  //<----- Updating Buttons Text
            btnWash.text = "Wash Mochi: $WashScore"

            if(HungerScore <= 0 ){

                HungerScore = 0

                btnFeed.text = "Feed Mochi: $HungerScore"         //Display Hunger Score
                btnPlay.text = "Play With Mochi: $PlayScore"      //Display Play Score
                btnWash.text = "Wash Mochi: $WashScore"           //Display Wash Score

            }
            if (WashScore <=0){

                WashScore = 0

                btnFeed.text = "Feed Mochi: $HungerScore"         //Display Hunger Score
                btnPlay.text = "Play With Mochi: $PlayScore"      //Display Play Score
                btnWash.text = "Wash Mochi: $WashScore"           //Display Wash Score

            }
            if (PlayScore <= 0){


                PlayScore = 0

                btnFeed.text = "Feed Mochi: $HungerScore"         //Display Hunger Score
                btnPlay.text = "Play With Mochi: $PlayScore"      //Display Play Score
                btnWash.text = "Wash Mochi: $WashScore"           //Display Wash Score



            }


        }








    }

    private fun ScoreCheck(i:Int): Boolean {

        val Score = i
        var State = true

        if(Score > 5){
            State = false
        }
        return State



    }

    //Play Button Pressed Logic
    private fun Play(){

        PlayScore += 3

        WashScore -= 1

        HungerScore -=2


    }

    //Feed Button Pressed Logic
    private fun Feed(){

        HungerScore += 3

        PlayScore -=1

        WashScore -=2


    }

    //Wash Button Pressed Logic
    private fun Wash(){

        WashScore += 3
        HungerScore -=1
        PlayScore -=2

    }

    private fun SadCheck(int: Int) : Boolean{  //<-- checking if he is sad
        var score = int

        if(score <5){ // checking if points are low

            return true

        }else{

            return false

            }

    }
    private fun onCreate(){
        val prefs = getSharedPreferences("game",Context.MODE_PRIVATE)

        HungerScore = prefs.getInt("feedStatus",HungerScore)
        WashScore = prefs.getInt("hungerStatus",HungerScore)
        PlayScore = prefs.getInt("playStatus",PlayScore)



    }

    override fun onPause(){
        super.onPause()

        val prefs = getSharedPreferences("game",Context.MODE_PRIVATE)
        dtLastUpdateTime = System.currentTimeMillis()
            prefs.edit(){
            putInt("feedStatus",HungerScore)
            putInt("washStatus",WashScore)
            putInt("playStatus",PlayScore)
            putLong("lastUpdated",dtLastUpdateTime)
                apply()
        }


    }


    private fun updateStatus(){
        val currentTime =System.currentTimeMillis()
        val difference = currentTime - dtLastUpdateTime
        if(difference > 24*60*60*1000){
            HungerScore -= 15
            WashScore -= 5
            PlayScore -=10


        }

    }



}