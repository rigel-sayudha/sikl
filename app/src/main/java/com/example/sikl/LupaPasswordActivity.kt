package com.example.sikl

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LupaPasswordActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lupa_password)
        val dbHelper = DatabaseHelper(this)
        val emailEditText = findViewById<TextInputEditText>(R.id.et_email)
        val passwordEditText = findViewById<TextInputEditText>(R.id.et_pass)
        val resetButton = findViewById<MaterialButton>(R.id.btn_change)

        resetButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val newPassword = passwordEditText.text.toString()
            dbHelper.updatePassword(email, newPassword)
            // redirect ke halaman login
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}