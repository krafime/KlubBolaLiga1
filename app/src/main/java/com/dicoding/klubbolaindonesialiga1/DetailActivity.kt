package com.dicoding.klubbolaindonesialiga1

import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule

@GlideModule
class DetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvName: TextView = findViewById(R.id.tv_name)
        val tvDesc: TextView = findViewById(R.id.tv_desc)
        val image: ImageView = findViewById(R.id.imageDetail)

        val intentData = intent
        tvName.text = intentData.getStringExtra("nama")
        tvDesc.text = intentData.getStringExtra("deskripsi")

        val context: Context = this
        Glide.with(context).load(intentData.getStringExtra("foto")).into(image)

        supportActionBar?.apply {
            title = ("Klub " + intentData.getStringExtra("nama"))
        }
    }
}

