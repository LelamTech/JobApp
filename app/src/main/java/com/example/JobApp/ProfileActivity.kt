package com.example.JobApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    private lateinit var editprof:Button
    private lateinit var log_out:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)



        editprof = findViewById(R.id.updateButton)
        log_out = findViewById(R.id.logout_Button)

        editprof.setOnClickListener {
            val intent = Intent(this, EditProfile::class.java)
            startActivity(intent)

            finish()
        }
        log_out.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            finish()
        }



    }
}

