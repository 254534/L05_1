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
import android.widget.SeekBar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class Activity2 : AppCompatActivity() {
    private lateinit var text1: EditText
    private lateinit var text2: EditText
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
        text1.setBackgroundColor(color)
        text2.setBackgroundColor(color)
        text1.setTextColor(Color.WHITE)
        text2.setTextColor(Color.WHITE)
    }

    fun changeFontBothTexts(typeface: Typeface) {
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
            R.id.activity2_submenu1_option3 -> {
                changeFontBothTexts(Typeface.DEFAULT)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        val seekBar: SeekBar = findViewById(R.id.seekBar)
        seekBar.max = 30
        seekBar.setOnSeekBarChangeListener(seekBarListener)
//        setNavigationButtons()
        text1 = findViewById(R.id.editText1)
        text2 = findViewById(R.id.editText2)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity2_menu, menu)
        return true
    }

    val seekBarListener = object: SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
            val fontSize: Int = i + 20
            text1.textSize = fontSize.toFloat()
            text2.textSize = fontSize.toFloat()
        }

        override fun onStartTrackingTouch(seekBar: SeekBar) {}
        override fun onStopTrackingTouch(seekBar: SeekBar) {}
    }
}