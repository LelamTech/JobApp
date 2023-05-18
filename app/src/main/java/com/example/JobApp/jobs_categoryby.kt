package com.example.JobApp

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class jobs_categoryby : AppCompatActivity() {

    private var dbref = FirebaseDatabase.getInstance().getReference("Jobs")
    private lateinit var jobRecyclerView: RecyclerView
    private lateinit var searchEditText: EditText
    private lateinit var jobArrayList: ArrayList<company>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jobs_categoryby)

        jobRecyclerView.layoutManager = LinearLayoutManager(this)
        jobRecyclerView.setHasFixedSize(true)

        jobArrayList = arrayListOf<company>()


        fun getJobData() {
            dbref.orderByChild("ccategory").equalTo("construction").addValueEventListener(object :
                ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {

                    if (snapshot.exists()) {
                        for (jobSnapshot in snapshot.children) {
                            val job = jobSnapshot.getValue(company::class.java)

                            jobArrayList.add(job!!)

                        }
                        jobRecyclerView.adapter?.notifyDataSetChanged()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Do nothing for now
                }

            })

            //navbar
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
                val intent = Intent(this, job_add::class.java)
                startActivity(intent)
            }


        }
    }
}