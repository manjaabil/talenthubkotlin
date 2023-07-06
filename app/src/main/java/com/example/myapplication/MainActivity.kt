package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var majorEditText: EditText
    private lateinit var semesterEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById<EditText>(R.id.nameEditText)
        emailEditText = findViewById<EditText>(R.id.emailEditText)
        majorEditText = findViewById<EditText>(R.id.majorEditText)
        semesterEditText = findViewById<EditText>(R.id.semesterEditText)
        loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val major = majorEditText.text.toString()
            val semester = semesterEditText.text.toString().toIntOrNull()

            if (validateName(name) && validateEmail(email) && validateMajor(major) && validateSemester(semester)) {
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("name", name)
                intent.putExtra("email", email)
                intent.putExtra("major", major)
                intent.putExtra("semester", semester)
                startActivity(intent)
            }
        }
    }

    private fun validateName(name: String): Boolean {
        if (name.isEmpty()) {
            nameEditText.error = "Nama harus diisi"
            return false
        }
        return true
    }

    private fun validateEmail(email: String): Boolean {
        if (email.isEmpty()) {
            emailEditText.error = "Email harus diisi"
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.error = "Email tidak valid"
            return false
        }
        return true
    }

    private fun validateMajor(major: String): Boolean {
        if (major.isEmpty()) {
            majorEditText.error = "Jurusan harus diisi"
            return false
        }
        return true
    }

    private fun validateSemester(semester: Int?): Boolean {
        if (semester == null || semester <= 0) {
            semesterEditText.error = "Semester tidak valid"
            return false
        }
        return true
    }
}