package com.example.sikl.ui.account

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sikl.MainActivity
import com.example.sikl.R
import com.example.sikl.databinding.FragmentAccountBinding
import com.google.android.material.button.MaterialButton

class AccountFragment : Fragment() {

    private var _binding: FragmentAccountBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val logout = view?.findViewById<MaterialButton>(R.id.signout)

        logout?.setOnClickListener{
            requireActivity().run {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
                activity?.finish()
            }
        }
//                val bind = FragmentAccountBinding.inflate(layoutInflater)
//        bind.signout.setOnClickListener {
//            activity?.let {
//                val intent = Intent(it, MainActivity::class.java)
//                it.startActivity(intent)
//            }
//        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}