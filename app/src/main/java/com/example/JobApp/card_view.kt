package com.example.JobApp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class card_view : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_view)

        // Get a reference to the "find Another job" button

        val imageButton = findViewById<ImageButton>(R.id.profile)

        imageButton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        val category = findViewById<ImageButton>(R.id.catogery)
        category.setOnClickListener {
            val intent = Intent(this, job_add::class.java)
            startActivity(intent)
        }



        val inq= findViewById<ImageButton>(R.id.imageView6)
        inq.setOnClickListener {
            val intent = Intent(this, activity_insertion::class.java)
            startActivity(intent)
        }



    }
}