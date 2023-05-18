package com.example.JobApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseApp.initializeApp(this)

        val database = FirebaseDatabase.getInstance().reference
        val button = findViewById<Button>(R.id.btnGetstart)

        database.child("users").child("userId").setValue("Ryan")


        button.setOnClickListener {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
        }



    }
}