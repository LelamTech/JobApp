package com.example.JobApp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class job_category : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_category)


       val it = findViewById<ImageView>(R.id.imageView3)

        it.setOnClickListener {
            val intent = Intent(this, JobListingActivity::class.java)
            startActivity(intent)
        }

        val construction = findViewById<ImageView>(R.id.imageView4)

        construction.setOnClickListener {
            val intent = Intent(this, JobListingActivity::class.java)
            startActivity(intent)
        }

        val school = findViewById<ImageView>(R.id.imageView5)

        school.setOnClickListener {
            val intent = Intent(this, JobListingActivity::class.java)
            startActivity(intent)
        }

        val hotel = findViewById<ImageView>(R.id.imageView6)

        hotel.setOnClickListener {
            val intent = Intent(this, JobListingActivity::class.java)
            startActivity(intent)
        }



        val other= findViewById<ImageView>(R.id.imageView8)

        other.setOnClickListener {
            val intent = Intent(this, JobListingActivity::class.java)
            startActivity(intent)
        }

        val imageButton = findViewById<ImageButton>(R.id.vProfile)

        imageButton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        val home = findViewById<ImageButton>(R.id.vhome)
        home.setOnClickListener {
            val intent = Intent(this, job_category::class.java)
            startActivity(intent)
        }

        val inq = findViewById<ImageButton>(R.id.vInqury)
        inq.setOnClickListener {
            val intent = Intent(this, activity_insertion::class.java)
            startActivity(intent)
        }
        val pos = findViewById<ImageButton>(R.id.vCategory)
        pos.setOnClickListener {
            val intent = Intent(this, post_jobs::class.java)
            startActivity(intent)
        }
    }
}