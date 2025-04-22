package com.example.sikl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.sikl.databinding.ActivityHomeBinding
import com.example.sikl.ui.account.AccountFragment
import com.example.sikl.ui.explore.ExploreFragment
import com.example.sikl.ui.home.HomeFragment


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val HomeFragment = HomeFragment()
    private val ExploreFragment = ExploreFragment()
    private val AccountFragment = AccountFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment)

        val buttom_navigation = findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(
            R.id.nav_view
        )
        buttom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_home -> replaceFragment(HomeFragment)
                R.id.navigation_explore -> replaceFragment(ExploreFragment)
                R.id.navigation_acc -> replaceFragment(AccountFragment)
            }
            true
        }


    }

    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }

}