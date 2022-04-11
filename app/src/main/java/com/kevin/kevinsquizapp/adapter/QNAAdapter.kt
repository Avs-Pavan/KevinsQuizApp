package com.kevin.kevinsquizapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kevin.kevinsquizapp.QAModel
import com.kevin.kevinsquizapp.R
import com.kevin.kevinsquizapp.adapter.QNAAdapter.MyViewHolder
import timber.log.Timber


class QNAAdapter(val context: Context) : RecyclerView.Adapter<MyViewHolder>() {
    private lateinit var questions: List<QAModel>
    private lateinit var recyclerClickListener: RecyclerClickListener
    fun setRecyclerClickListener(recyclerClickListener: RecyclerClickListener) {
        this.recyclerClickListener = recyclerClickListener
    }

    fun setMenuOptionList(questions: List<QAModel>) {
        this.questions = questions
        notifyDataSetChanged()
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dp: ImageView = view.findViewById(R.id.image_card)
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
        holder.dp.load(questions[position].image)
        holder.options?.adapter = AnswersAdapter(questions[position].answers) {
            Timber.e("Clicked option $it")
        }
    }

    override fun getItemCount(): Int {
        return 5
    }
}