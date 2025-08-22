package com.kotlintutorial.quizapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kotlintutorial.quizapp.MainActivity
import com.kotlintutorial.quizapp.R
import com.kotlintutorial.quizapp.utils.Constants

class ResultActivity : AppCompatActivity() {
    private lateinit var textViewScore : TextView //Initializing the UI components
    private lateinit var textViewName:TextView
    private lateinit var finishButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        textViewScore = findViewById(R.id.tv_score) //Defining the components by using findViewById to link UI components to activity
        textViewName = findViewById(R.id.tv_name)
        finishButton = findViewById(R.id.btn_finish)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0) //Retrieving the value from another activity by using the key
        val score = intent.getIntExtra(Constants.SCORE,0)
        val name = intent.getStringExtra(Constants.USER_NAME)

        textViewScore.text = "Your score is $score out of $totalQuestions"
        textViewName.text = name

        finishButton.setOnClickListener {
            Intent(this,MainActivity::class.java).also{
                startActivity(it)
                finish()
            }
        }

    }
}