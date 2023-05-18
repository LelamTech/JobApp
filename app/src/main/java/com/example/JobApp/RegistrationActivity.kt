package com.example.JobApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var registerButton: Button

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        emailEditText = findViewById(R.id.email_registration)
        passwordEditText = findViewById(R.id.registration_password)
        registerButton = findViewById(R.id.btn_register)

        auth = FirebaseAuth.getInstance()

        registerButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                registerUser(email, password)
            } else {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun registerUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    // Registration successful, do something with the user object
                    // For example, redirect to the main activity
                    val intent = Intent(this, job_category::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Registration failed. Please try again.", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
