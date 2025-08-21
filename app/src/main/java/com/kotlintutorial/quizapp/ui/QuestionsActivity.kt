package com.kotlintutorial.quizapp.ui

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.kotlintutorial.quizapp.R
import com.kotlintutorial.quizapp.model.Question
import com.kotlintutorial.quizapp.utils.Constants

class QuestionsActivity : AppCompatActivity(), View.OnClickListener  { //Inherting the onClick Class to allow us to use its methods
    private lateinit var progressBar:ProgressBar
    private lateinit var textViewProgress: TextView
    private lateinit var textViewQuestion:TextView
    private lateinit var footballImage:ImageView


    private lateinit var textViewOptionOne:TextView
    private lateinit var textViewOptionTwo:TextView
    private lateinit var textViewOptionThree:TextView
    private lateinit var textViewOptionFour:TextView

    private lateinit var checkButton:Button

    private var questionCounter = 0
    private lateinit var questionList:MutableList<Question>
    private var selectedAnswer = 0
    private lateinit var currentQuestion:Question
    private var answered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_questions)

        progressBar = findViewById(R.id.progressBar)
        textViewProgress = findViewById(R.id.text_view_progress)
        textViewQuestion = findViewById(R.id.question_text_view)
        footballImage = findViewById(R.id.image_football)
        checkButton = findViewById(R.id.buttonCheck)


        textViewOptionOne = findViewById(R.id.text_view_option_one)
        textViewOptionTwo = findViewById(R.id.text_view_option_two)
        textViewOptionThree = findViewById(R.id.text_view_option_three)
        textViewOptionFour = findViewById(R.id.text_view_option_four)

        textViewOptionOne.setOnClickListener(this)
        textViewOptionTwo.setOnClickListener(this)
        textViewOptionThree.setOnClickListener(this)
        textViewOptionFour.setOnClickListener(this)
        checkButton.setOnClickListener(this)


        questionList = Constants.getQuestions() //Singleton Object that allows us to get questions we have stored
        Log.d("QuestionsSize","${questionList.size}") //A debug tool to allow us to see if the questionList works or not
        showNextQuestion() //This is called to display the first question
    }

    private fun showNextQuestion(){
        resetOptions() //Resets the button to default backgrounds
        val question = questionList[questionCounter] //Assigns the question object from the questionList in Constants
        footballImage.setImageResource(question.image) //It uses the question object to get the image and uses it in image view
        progressBar.progress = questionCounter //Assigns the progress bar to the questionCounter to let user know how many questions left
        textViewProgress.text = "${questionCounter+1}/${progressBar.max}" //assigns the text view to questionCounter to let them know what question number they are on and also shows them how many questions they will be asked
        textViewQuestion.text = question.question //Displays the question the user will be asked on textView
        textViewOptionOne.text = question.optionOne //Display all the options on textView
        textViewOptionTwo.text = question.optionTwo
        textViewOptionThree.text = question.optionThree
        textViewOptionFour.text = question.optionFour

        if(questionCounter < questionList.size){ //Checks if the counter is below the arrayList size as that is the number of questions left
            checkButton.text="CHECK" //Assigns the text to the button
            currentQuestion = questionList[questionCounter] //This assigns the question in another variable to be used outside this scope and to check if the user got the answer correct once answered
        } else{
            checkButton.text="FINISH" //Assigns the text to the button
        }
        questionCounter++ //Increments questionCounter to let app know to move to the next question
        answered = false //Resets answered as its a new question




    }

    private fun resetOptions(){
        val options = mutableListOf<TextView>()
        options.add(textViewOptionOne) //Add all the buttons in the list, make it easier to call the functions, rather than do it indvidually
        options.add(textViewOptionTwo)
        options.add(textViewOptionThree)
        options.add(textViewOptionFour)

        for(option in options){
            option.setTextColor(Color.WHITE) //Change text color to original
            option.typeface = Typeface.DEFAULT //Change text font to original
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_border_bg) //Changes background to default background
        }

    }

    private fun selectedOption(textView:TextView,selectedOptionNumber:Int){
        resetOptions() //Called to restart on all button once the user select a different button
        selectedAnswer = selectedOptionNumber //This is used to check if the answer the user written was correct
        textView.setTextColor(Color.WHITE) //Change text color
        textView.setTypeface(textView.typeface,Typeface.BOLD) //Change text font to bold to show its displayed
        textView.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg) //Changes background to show the button has been selected
    }

    private fun checkAnswer(){
        if(selectedAnswer == 0){ //Checks if user hasn't answered anything
            Toast.makeText(this@QuestionsActivity,"Select an option",Toast.LENGTH_SHORT).show() //Display a message to the user to click a button
            return //Exits the function and doesn't allow user to go to next question
        }
        answered = true //Assigns answered to true as user has now answered question
        if(selectedAnswer == currentQuestion.correctAnswer){ //Checks if the user answer matches with the correct one assigned in the property
            when(selectedAnswer){ //Once passed through the validation, it now checks which number was assigned
                1 -> {
                    textViewOptionOne.background = ContextCompat.getDrawable(this,R.drawable.correct_option_border_bg) //Once the number is found it changes background to let the user know they got it correct
                }
                2 -> {
                    textViewOptionTwo.background = ContextCompat.getDrawable(this,R.drawable.correct_option_border_bg)
                }
                3 -> {
                    textViewOptionThree.background = ContextCompat.getDrawable(this,R.drawable.correct_option_border_bg)
                }
                4 -> {
                    textViewOptionFour.background = ContextCompat.getDrawable(this,R.drawable.correct_option_border_bg)
                }
            }
        }
        else{
            when(selectedAnswer){ // now it checks which number was assigned
                1 -> {
                    textViewOptionOne.background = ContextCompat.getDrawable(this,R.drawable.wrong_option_border_bg) //Once the number is found it changes background to let the user know they got it correct
                }
                2 -> {
                    textViewOptionTwo.background = ContextCompat.getDrawable(this,R.drawable.wrong_option_border_bg)
                }
                3 -> {
                    textViewOptionThree.background = ContextCompat.getDrawable(this,R.drawable.wrong_option_border_bg)
                }
                4 -> {
                    textViewOptionFour.background = ContextCompat.getDrawable(this,R.drawable.wrong_option_border_bg)
                }
            }
        }
        checkButton.text = "NEXT"
        showSolution() //Calling the function to show the right answer
    }

    private fun showSolution(){
        selectedAnswer = currentQuestion.correctAnswer //Changes the user answer to the correct one to display it after they go it wrong
        when (selectedAnswer) {
            1 -> {
                textViewOptionOne.background = ContextCompat.getDrawable(this,R.drawable.correct_option_border_bg) //Once the number is found it changes background to let the user know they got it correct
            }
            2 -> {
                textViewOptionTwo.background = ContextCompat.getDrawable(this,R.drawable.correct_option_border_bg)
            }
            3 -> {
                textViewOptionThree.background = ContextCompat.getDrawable(this,R.drawable.correct_option_border_bg)
            }
            4 -> {
                textViewOptionFour.background = ContextCompat.getDrawable(this,R.drawable.correct_option_border_bg)
            }
        }
    }

    override fun onClick(view: View?) { //Now using the inherited methods, this checks if components in the activity has been clicked
        when(view?.id){
            R.id.text_view_option_one -> { //Checks if the opition1 is clicked
                selectedOption(textViewOptionOne,1) //Calls the function to change the layout of the button to show its been clicked
            }
            R.id.text_view_option_two -> {
                selectedOption(textViewOptionTwo,2)
            }
            R.id.text_view_option_three -> {
                selectedOption(textViewOptionThree,3)
            }
            R.id.text_view_option_four -> {
                selectedOption(textViewOptionFour,4)
            }
            R.id.buttonCheck -> {
                if(!answered){ //Checks if user answered the question
                    checkAnswer()
                } else{
                    showNextQuestion()
                }
                selectedAnswer = 0 //Resets the variable so then the user can record his answer
            }
        }
    }


}