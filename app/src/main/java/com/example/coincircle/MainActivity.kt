package com.example.coincircle

import TransactionsFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Load initial fragment - Home
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, HomeFragment())
            .commit()

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_person -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, ProfileFragment())
                        .commit()
                    true
                }
                R.id.item_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, HomeFragment())
                        .commit()
                    true
                }
                R.id.item_group -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, GroupsFragment())
                        .commit()
                    true
                }
                R.id.item_transaction -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, TransactionsFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}
