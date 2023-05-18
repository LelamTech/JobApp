package com.example.JobApp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore

class EditProfile : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var updateButton: Button

    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    private lateinit var currentUser: FirebaseUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        nameEditText = findViewById(R.id.nameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        updateButton = findViewById(R.id.updateButton)

        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()

        currentUser = auth.currentUser!!

        // Load current user profile data
        loadUserProfile()

        updateButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()

            if (name.isNotEmpty() && email.isNotEmpty()) {
                updateUserProfile(name, email)
            } else {
                Toast.makeText(this, "Please enter name and email", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadUserProfile() {
        val userRef = firestore.collection("users").document(currentUser.uid)

        userRef.get().addOnSuccessListener { document ->
            if (document != null) {
                val name = document.getString("name")
                val email = document.getString("email")

                nameEditText.setText(name)
                emailEditText.setText(email)
            } else {
                Toast.makeText(this, "Failed to load user profile", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(this, "Failed to load user profile: ${exception.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUserProfile(name: String, email: String) {
        val userRef = firestore.collection("users").document(currentUser.uid)

        val updatedProfile = hashMapOf(
            "name" to name,
            "email" to email
        )

        userRef.update(updatedProfile as Map<String, Any>)
            .addOnSuccessListener {
                Toast.makeText(this, "Profile updated successfully", Toast.LENGTH_SHORT).show()
                finish()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Failed to update profile: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
