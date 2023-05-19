package com.example.JobApp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class JobListingActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var searchEditText: EditText
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var jobs: ArrayList<String>
    private lateinit var filteredJobs: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_listing)

        listView = findViewById(R.id.listView)
        searchEditText = findViewById(R.id.searchEditText)

        // Initialize the jobs in the ListView
        jobs = ArrayList()
        jobs.add("Software Engineer")
        jobs.add("Data Analyst")
        jobs.add("Product Manager")
        jobs.add("System Analyst")
        jobs.add("Marketing Specialist")
        jobs.add("Accountant")
        jobs.add("Field Manager")
        jobs.add("Accountant")
        jobs.add("Construction Worker")
        jobs.add("Chief Consultant")
        jobs.add("Forensics")
        jobs.add("Finance Auditor")


        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, jobs)
        listView.adapter = adapter


        filteredJobs = ArrayList(jobs)

        listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val selectedJob = jobs[position]
                Toast.makeText(this, "Clicked on $selectedJob", Toast.LENGTH_SHORT).show()
                // Perform any desired actions on item click here
            }


        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterJobs(s.toString())
            }
        })
    }


    private fun filterJobs(query: String) {
        filteredJobs.clear()
        if (query.isEmpty()) {
            filteredJobs.addAll(jobs)
        } else {
            val lowercaseQuery = query.toLowerCase()
            for (job in jobs) {
                if (job.toLowerCase().contains(lowercaseQuery)) {
                    filteredJobs.add(job)
                }
            }
        }

        adapter.clear()
        adapter.addAll(filteredJobs)
        adapter.notifyDataSetChanged()
    }
}
