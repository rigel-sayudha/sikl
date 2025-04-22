package com.example.sikl

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.sikl.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val username = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.et_email)
        val password = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.et_pass)
        val login = findViewById<com.google.android.material.button.MaterialButton>(R.id.btn_masuk)

        login.setOnClickListener {
            val email = username.text.toString()
            val pass = password.text.toString()
            if (email == "admin@gmail.com" && pass == "123") {
                Toast.makeText(applicationContext, "Login Berhasil", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val builder = AlertDialog.Builder(this@MainActivity)
                builder.setMessage(" Email atau Password Anda Salah")
                    .setNegativeButton("Coba Lagi", null).create().show()
                username.setText("")
                password.setText("")
            }
        }
    }
}
