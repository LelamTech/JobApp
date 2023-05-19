package com.example.JobApp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*


class post_jobs : AppCompatActivity() {

    private lateinit var vProfile: ImageButton
    private lateinit var vCategory: ImageButton
    private lateinit var vInqury: ImageButton
    private lateinit var vhome: ImageButton
    private lateinit var database: DatabaseReference




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
        database = FirebaseDatabase.getInstance().reference.child("Jobs")

        // Fetch data from the database
        fetchDataFromDatabase()
    }

    private fun fetchDataFromDatabase() {
        // Read the data from the database
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val jobs = ArrayList<String>()

                // Iterate through each child node
                for (snapshot in dataSnapshot.children) {
                    val job = snapshot.getValue(CompanyData::class.java)
                    job?.let {
                        jobs.add(it.toString())
                    }
                }

                // Use the fetched data (e.g., update UI, populate list, etc.)
                // TODO: Update your UI or process the fetched jobs list as per your requirements
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle any errors that occur during data fetching
                // TODO: Handle the error as per your requirements
            }
        })



    }






}
