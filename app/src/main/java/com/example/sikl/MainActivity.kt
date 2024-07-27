package com.example.sikl

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbHelper = DatabaseHelper(this)
        val emailEditText = findViewById<TextInputEditText>(R.id.et_email)
        val passwordEditText = findViewById<TextInputEditText>(R.id.et_pass)
        val loginButton = findViewById<MaterialButton>(R.id.btn_masuk)
        val lupaPasswordButton = findViewById<TextView>(R.id.tv_lupa)
        val registerButton = findViewById<TextView>(R.id.tv_Register)
//        val deleteButton = findViewById<Button>(R.id.delete_button)


        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (dbHelper.checkUser(email, password)) {
                // login success, redirect to home screen
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // login failed, show error message
                Toast.makeText(this, "Login Failed, email atau password salah", Toast.LENGTH_SHORT).show()
            }
        }

        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        }

        lupaPasswordButton.setOnClickListener {
            val intent = Intent(this, LupaPasswordActivity::class.java)
            startActivity(intent)

        }

//        deleteButton.setOnClickListener {
//            val email = emailEditText.text.toString()
//            dbHelper.deleteUser(email)
//            // clear data yang ditampilkan pada layout
//            emailEditText.setText("")
//            passwordEditText.setText("")
//        }
    }

}
