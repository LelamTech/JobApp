package com.example.JobApp


import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class activity_insertion : AppCompatActivity(){

    //initialize views
    private lateinit var username: EditText
    private lateinit var email: EditText
    private lateinit var Msg: EditText
    private lateinit var btnSaveData: Button
    private lateinit var  btnJob : CardView


    //create db reference
    private lateinit var dbRef: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertion)
        supportActionBar?.hide()

        username = findViewById(R.id.Name)
        email = findViewById(R.id.Email)
        Msg = findViewById(R.id.Msg)
        btnSaveData = findViewById(R.id.btnSave)


        //save data
        btnSaveData.setOnClickListener {
            saveData()
        }
    }

    private fun saveData() {

        //getting values
        val Name = username.text.toString()
        val Email = email.text.toString()
        val Inq = Msg.text.toString()

        //form validations
        if (Name.isEmpty()) {
            username.error = "Please enter name"
        }
        if (Email.isEmpty()) {
            email.error = "Please enter email"
        }
        if (Inq.isEmpty()) {
            Msg.error = "Please enter a message"
        }


        btnJob.setOnClickListener{

            val intent = Intent(this, job_category::class.java)
            startActivity(intent)
        }
    }




}






