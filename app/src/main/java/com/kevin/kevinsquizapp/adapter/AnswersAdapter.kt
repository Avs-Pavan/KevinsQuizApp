package com.kevin.kevinsquizapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kevin.kevinsquizapp.Answer
import com.kevin.kevinsquizapp.R


class AnswersAdapter(
    private val answers: List<Answer>, val correctAnswer: Int,
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
        if (answers[position].isDisabled)
            holder.itemView.alpha = 0.5f
        holder.number.text = "${position + 1}"
        holder.options.text = answers[position].answer
        holder.itemView.setOnClickListener {
            if (position != correctAnswer) {
                holder.itemView.startAnimation(
                    AnimationUtils.loadAnimation(
                        holder.itemView.context,
                        R.anim.shake
                    )
                )
                holder.itemView.context.vibratePhone()
                holder.itemView.alpha = 0.5f
                answers[position].isDisabled = true
            }
            recyclerClickListener.onclick(position)
        }
    }

    override fun getItemCount(): Int {
        return answers.size
    }
}

private fun Context.vibratePhone() {
    val vibrator = this?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    if (Build.VERSION.SDK_INT >= 26) {
        vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
    } else {
        vibrator.vibrate(200)
    }
}
