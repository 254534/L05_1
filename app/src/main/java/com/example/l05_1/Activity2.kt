package com.example.l05_1

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.fonts.Font
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
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

    fun changeBackgroundColorBothTexts(color: Int) {
        val text1: EditText = findViewById(R.id.editText1)
        val text2: EditText = findViewById(R.id.editText2)
        text1.setBackgroundColor(color)
        text2.setBackgroundColor(color)
        text1.setTextColor(Color.WHITE)
        text2.setTextColor(Color.WHITE)
    }

    fun changeFontBothTexts(typeface: Typeface) {
        val text1: EditText = findViewById(R.id.editText1)
        val text2: EditText = findViewById(R.id.editText2)
        text1.typeface = typeface
        text2.typeface = typeface
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.activity2_option1 -> {
                changeBackgroundColorBothTexts(Color.rgb(216,9,126))
                true
            }
            R.id.activity2_option2 -> {
                changeBackgroundColorBothTexts(Color.rgb(140,87,156))
                true
            }
            R.id.activity2_option3 -> {
                changeBackgroundColorBothTexts(Color.rgb(36,70,142))
                true
            }
            R.id.activity2_submenu1_option1 -> {
                changeFontBothTexts(Typeface.MONOSPACE)
                true
            }
            R.id.activity2_submenu1_option2 -> {
                changeFontBothTexts(Typeface.DEFAULT_BOLD)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
//        setNavigationButtons()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity2_menu, menu)
        return true
    }
}