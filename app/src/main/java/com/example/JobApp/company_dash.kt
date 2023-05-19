package com.example.JobApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class company_dash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_dash)

        val  createJob = findViewById<Button>(R.id.create_job)

        createJob.setOnClickListener {
            val intent = Intent(this@company_dash, job_add::class.java)
            startActivity(intent)
            finish()
        }


        val  viewJobs = findViewById<Button>(R.id.view_jobs)

        viewJobs.setOnClickListener {
            val intent = Intent(this@company_dash, post_jobs::class.java)
            startActivity(intent)
            finish()
        }
        val imageButton = findViewById<ImageButton>(R.id.vProfile)
        imageButton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
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
        val vCategory=findViewById<ImageButton>(R.id.vCategory)
        vCategory.setOnClickListener {
            val intent = Intent(this, job_add::class.java)
            startActivity(intent)
        }

    }
}