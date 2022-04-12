package com.kevin.kevinsquizapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kevin.kevinsquizapp.QAModel
import com.kevin.kevinsquizapp.R
import com.kevin.kevinsquizapp.adapter.QNAAdapter.MyViewHolder


class QNAAdapter() : RecyclerView.Adapter<MyViewHolder>() {
    private var questions: List<QAModel> = ArrayList()
    private lateinit var recyclerClickListener: QnASelectionListener

    fun setRecyclerClickListener(recyclerClickListener: QnASelectionListener) {
        this.recyclerClickListener = recyclerClickListener
    }

    fun setMenuOptionList(questions: List<QAModel>) {
        this.questions = questions
        notifyDataSetChanged()
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dp: ImageView = view.findViewById(R.id.image_card)
        val questionNumber: TextView = view.findViewById(R.id.questionNumber)
        val options: RecyclerView = view.findViewById(R.id.options_rv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.qa_row, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        val question = questions[position]
        holder.dp.load(question.image)
        holder.questionNumber.text = "" + (position + 1)
        holder.options?.adapter = AnswersAdapter(question.answers, question.correctAnswer) {
            if (it == question.correctAnswer)
                recyclerClickListener.onCorrectAnswerClicked(position)
            else
                recyclerClickListener.onWrongAnswerClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return questions.size
    }
}