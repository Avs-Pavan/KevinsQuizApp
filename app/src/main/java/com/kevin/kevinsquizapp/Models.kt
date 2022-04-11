package com.kevin.kevinsquizapp

data class QAModel(
    val image:Int,
    val question: String,
    val answers: List<Answer>,
    val correctAnswer: Int
)

data class Answer(val answerNumber: Int, val answer: String)