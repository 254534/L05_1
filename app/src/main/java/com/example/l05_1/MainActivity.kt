package com.example.l05_1

import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private var counter = 0
    fun setNavigationButtons() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        navView.setNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
//                R.id.drawer_button1 -> startActivity(Intent(this, MainActivity::class.java))
                R.id.drawer_button2 -> {
                    drawerLayout.close()
                    startActivity(Intent(this, Activity2::class.java))
                }
                R.id.drawer_button3 -> {
                    drawerLayout.close()
                    startActivity(Intent(this, Activity3::class.java))
                }
            }

            true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setNavigationButtons()

        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener { view ->
            counter += 1
            findViewById<TextView>(R.id.textViewCounter).text = counter.toString()
        }
    }
}