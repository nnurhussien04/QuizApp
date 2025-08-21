package com.kotlintutorial.quizapp.model

data class Question(
    val id:Int, //Needed to identify question number
    val question:String, //The questions asked to the user
    val image:Int, //Images stored in drawable and drawables stores images in numbers
    val optionOne:String, //Answers are mutliple choice stored in string
    val optionTwo:String,
    val optionThree:String,
    val optionFour:String,
    val correctAnswer:Int)
