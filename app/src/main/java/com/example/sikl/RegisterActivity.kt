package com.example.sikl

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val dbHelper = DatabaseHelper(this)

        val namaEditText = findViewById<TextInputEditText>(R.id.et_nama)
        val nimEditText = findViewById<TextInputEditText>(R.id.et_nim)
        val kelasEditText = findViewById<TextInputEditText>(R.id.et_kelas)
        val emailEditText = findViewById<TextInputEditText>(R.id.et_email)
        val passwordEditText = findViewById<TextInputEditText>(R.id.et_pass)
        val registerButton = findViewById<MaterialButton>(R.id.btn_register)

        registerButton.setOnClickListener {
            val nama = namaEditText.text.toString()
            val nim = nimEditText.text.toString()
            val kelas = kelasEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // simpan email dan nama ke shared preferences
            val sharedPref = getSharedPreferences("user_data", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("nama", nama)
            editor.putString("nim", nim)
            editor.putString("kelas", kelas)
            editor.putString("email", email)
            editor.apply()

            // simpan data ke database
            dbHelper.insertUser(nama, nim, kelas, email, password)

            // redirect ke halaman login
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}