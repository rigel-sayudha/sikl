package com.example.sikl.ui.account
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.sikl.MainActivity
import com.example.sikl.R

class AccountFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_account, container, false)

        // ambil data email dan nama dari shared preferences
        val sharedPref = activity?.getSharedPreferences("user_data", Context.MODE_PRIVATE)
        val nama = sharedPref?.getString("nama", "")
        val nim = sharedPref?.getString("nim", "")
        val kelas = sharedPref?.getString("kelas", "")
        val email = sharedPref?.getString("email", "")

        // tampilkan data di layout
        val namaTextView = view.findViewById<TextView>(R.id.tv_nama)
        val nimTextView = view.findViewById<TextView>(R.id.tv_nim)
        val kelasTextView = view.findViewById<TextView>(R.id.tv_kelas)
        val emailTextView = view.findViewById<TextView>(R.id.tv_email)
        namaTextView.text = nama
        nimTextView.text = nim
        kelasTextView.text = kelas
        emailTextView.text = email

        val button = view.findViewById<Button>(R.id.signout)
        button.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        return view
    }
}
