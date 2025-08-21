package com.kotlintutorial.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.kotlintutorial.quizapp.ui.QuestionsActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startButton: Button = findViewById(R.id.button_start)
        val editNameText:EditText = findViewById(R.id.name)
        startButton.setOnClickListener {
            if(!editNameText.text.isEmpty()){ //Checks if the textbox is empty or not
                Intent(this@MainActivity,QuestionsActivity::class.java).also { //Stores the second activity there
                    startActivity(it) //Opens the second activty
                    finish() //Destory this activity as no longer needed
                }
            } else{
                Toast.makeText(this@MainActivity,"Please enter your name",Toast.LENGTH_LONG).show() //Display message to the user there is an error
            }
        }
    }
}