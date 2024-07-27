package com.example.sikl

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "db_login", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE user (nama TEXT, nim TEXT PRIMARY KEY, kelas TEXT, email TEXT, password TEXT );")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

    fun insertUser(nama: String, nim: String, kelas: String, email: String, password: String ) {
        val contentValues = ContentValues()
        contentValues.put("nama", nama)
        contentValues.put("nim", nim)
        contentValues.put("kelas", kelas)
        contentValues.put("email", email)
        contentValues.put("password", password)

        writableDatabase.insert("user", null, contentValues)
    }

    fun checkUser(email: String, password: String) : Boolean {
        val cursor = readableDatabase.rawQuery("SELECT * FROM user WHERE email=? AND password=?", arrayOf(email, password))
        if (cursor.count > 0) {
            cursor.close()
            return true
        }
        cursor.close()
        return false
    }

    fun updatePassword(email: String, newPassword: String) {
        val contentValues = ContentValues()
        contentValues.put("password", newPassword)
        writableDatabase.update("user", contentValues, "email=?", arrayOf(email))
    }

    fun deleteUser(email: String) {
        writableDatabase.delete("user", "email=?", arrayOf(email))
    }
}
