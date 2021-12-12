package com.example.l05_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class Activity2 : AppCompatActivity() {
    fun setNavigationButtons() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        navView.setNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.drawer_button1 -> startActivity(Intent(this, MainActivity::class.java))
//                R.id.drawer_button2 -> startActivity(Intent(this, Activity2::class.java))
                R.id.drawer_button3 -> startActivity(Intent(this, Activity2::class.java))
            }

            true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
//        setNavigationButtons()
    }
}