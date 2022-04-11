package com.kevin.kevinsquizapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kevin.kevinsquizapp.Answer
import com.kevin.kevinsquizapp.R


class AnswersAdapter(
    private val answers: List<Answer>,
    val recyclerClickListener: RecyclerClickListener
) : RecyclerView.Adapter<AnswersAdapter.MyViewHolder>() {


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val options: TextView = view.findViewById(R.id.label)
        val number: TextView = view.findViewById(R.id.logo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.option_row, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        holder.number.text = "${position+1}"
        holder.options.text = answers[position].answer
        holder.itemView.setOnClickListener { recyclerClickListener.onclick(position) }
    }

    override fun getItemCount(): Int {
        return answers.size
    }
}