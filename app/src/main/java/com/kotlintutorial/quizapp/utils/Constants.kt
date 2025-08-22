package com.kotlintutorial.quizapp.utils

import com.kotlintutorial.quizapp.R
import com.kotlintutorial.quizapp.model.Question

object Constants{ //Here we are creating a singleton class to allow us to only have one instance of this class, no need to create multiple new instances and reset position of the arrayList

    const val USER_NAME = "user_name" //These are the keys that is going to be use to pass and retrieve data
    const val TOTAL_QUESTIONS = "total_questions"
    const val SCORE = "correct_answers"


    fun getQuestions():MutableList<Question>{
        //val question = mutableListOf<Question>()
        val questions = ArrayList<Question>() //An array list to hold the question objects
        val q1 = Question( //Question Object being created, this is what will be used to create the question and get the answer, images and options
            1,
            "What is the player's name?",
            R.drawable.download,
            "Eden Hazard",
            "Robin Van Persie",
            "Maroune Fellaini",
            "Di Maria",
            1
        )
        questions.add(q1) //Here we are adding the question object to the array list for future use

        val q2 = Question(
            2,
            "Who is this coach?",
            R.drawable.canio,
            "Paolo Di Canio",
            "Roberto Mancini",
            "Claudio Ranieri",
            "Fabio Capello",
            1
        )
        questions.add(q2)

        val q3 = Question(
            3,
            "Who is this player?",
            R.drawable.cesar,
            "Julio Cesar",
            "Cafu",
            "Thiago Silva",
            "Rivaldo",
            1
        )
        questions.add(q3)

        val q4 = Question(
            4,
            "Who is this player?",
            R.drawable.dembele,
            "Ousmane Dembele",
            "Serge Gnabry",
            "Kingsley Coman",
            "Paul Pogba",
            1
        )
        questions.add(q4)

        val q5 = Question(
            5,
            "Which club’s logo is this?",
            R.drawable.fc_augsburg_logo,
            "VfB Stuttgart",
            "FC Augsburg",
            "Werder Bremen",
            "Mainz 05",
            2
        )
        questions.add(q5)

        val q6 = Question(
            6,
            "Who is this coach?",
            R.drawable.hasenhuttl,
            "Ralph Hasenhüttl",
            "Julian Nagelsmann",
            "Marco Rose",
            "Thomas Tuchel",
            1
        )
        questions.add(q6)

        val q7 = Question(
            7,
            "Who is this player?",
            R.drawable.imago164801, // Beckenbauer
            "Franz Beckenbauer",
            "Lothar Matthäus",
            "Gerd Müller",
            "Karl-Heinz Rummenigge",
            1
        )
        questions.add(q7)

        val q8 = Question(
            8,
            "Who is this coach?",
            R.drawable.ragnick,
            "Ralf Rangnick",
            "Jürgen Klopp",
            "Thomas Tuchel",
            "Hansi Flick",
            1
        )
        questions.add(q8)

        val q9 = Question(
            9,
            "Who is this player?",
            R.drawable.toure,
            "Yaya Touré",
            "Kolo Touré",
            "Didier Drogba",
            "Michael Essien",
            2
        )
        questions.add(q9)

        val q10 = Question(
            10,
            "Which club’s logo is this?",
            R.drawable.vasco_da_gama,
            "Botafogo",
            "Santos",
            "Flamengo",
            "Vasco da Gama",
            4
        )
        questions.add(q10)
        return questions
    }
}