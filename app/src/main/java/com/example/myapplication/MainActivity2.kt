package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val nameTextView: TextView = findViewById<TextView>(R.id.nameTextView)
        val emailTextView: TextView = findViewById<TextView>(R.id.emailTextView)
        val majorTextView: TextView = findViewById<TextView>(R.id.majorTextView)
        val semesterTextView: TextView = findViewById<TextView>(R.id.semesterTextView)

        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val major = intent.getStringExtra("major")
        val semester = intent.getIntExtra("semester", 0)

        nameTextView.text = "Nama: $name"
        emailTextView.text = "Email: $email"
        majorTextView.text = "Jurusan: $major"
        semesterTextView.text = "Semester: $semester"
    }
}
