package com.kevin.kevinsquizapp

data class QAModel(
    val image: String,
    val question: String,
    val answers: List<Answer>,
    val correctAnswer: Int
)

data class Answer(val answerNumber: Int, val answer: String, var isDisabled: Boolean)