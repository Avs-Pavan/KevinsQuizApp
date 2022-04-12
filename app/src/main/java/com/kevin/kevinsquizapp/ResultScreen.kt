package com.kevin.kevinsquizapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_result_screen.*

class ResultScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_screen)
        background?.load("https://c4.wallpaperflare.com/wallpaper/358/8/1021/captain-america-shields-optical-flares-stars-wallpaper-preview.jpg")

        rating?.setOnClickListener {
            showRating()
        }
    }


    private fun showRating() {
        val dialog = BottomSheetDialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val view: View = LayoutInflater.from(this).inflate(R.layout.rating_lay, null)

        val button :Button = view.findViewById(R.id.login_btn)
        button.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(this,Launcher::class.java))
            finish()
        }
        dialog.setContentView(view)
        dialog.setCancelable(true)
        dialog.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        dialog.show()
    }
}