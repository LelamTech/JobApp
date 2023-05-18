package com.example.JobApp

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class JobListingActivity : AppCompatActivity() {
    private lateinit var jobListingListView: ListView
    private lateinit var jobListings: Array<String>
    private lateinit var buttnback : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_listing)

        jobListingListView = findViewById(R.id.jobListingListView)
        buttnback = findViewById(R.id.btn_back)


        buttnback.setOnClickListener {
            val intent = Intent(this, job_category::class.java)
            startActivity(intent)

            finish()
        }
        jobListings = arrayOf(
            "Hospitality Services Coordinator",
            "Software Engineer",
            " Guest Experience Manager",
            "Construction Manager",
            "Journalist",
            "Public Relation",
            "System Analyst",
            "Technical Engineer",
            "Lab Technician",
            "Political Analyst",
            "Director of HR & Trainingt",
            "Product Manager",
            "Receiptionist",
            "Director of Operations",

        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, jobListings)
        jobListingListView.adapter = adapter

        jobListingListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectedJob = jobListings[position]

        }
    }
}
