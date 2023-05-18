package com.example.JobApp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class post_jobs : AppCompatActivity() {


    private lateinit var vProfile: ImageButton
    private lateinit var vCategory: ImageButton
    private lateinit var vInqury: ImageButton
    private lateinit var vhome: ImageButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_jobs)


        vProfile= findViewById(R.id.vProfile)
        vCategory=findViewById(R.id.vCategory)
        vInqury= findViewById(R.id.vInqury)
        vhome=findViewById(R.id.vhome)



        vProfile.setOnClickListener {
            val intent = Intent(this, company_dash::class.java)
            startActivity(intent)
        }
        vCategory.setOnClickListener {
            val intent = Intent(this, job_category::class.java)
            startActivity(intent)
        }


        vInqury.setOnClickListener {
            val intent = Intent(this, activity_insertion::class.java)
            startActivity(intent)
        }

        vhome.setOnClickListener {
            val intent = Intent(this, job_category::class.java)
            startActivity(intent)
        }


    }





}
