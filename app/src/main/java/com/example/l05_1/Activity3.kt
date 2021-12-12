package com.example.l05_1

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class Activity3 : AppCompatActivity() {
    private val PINK = Color.rgb(216,9,126)
    private val PURPLE = Color.rgb(140,87,156)
    private val BLUE = Color.rgb(36,70,142)
    private val mapEditText = mapOf(11 to Pair("PINK", PINK), 12 to Pair("PURPLE", PURPLE), 13 to Pair("BLUE", BLUE))

    private lateinit var editText: EditText

    fun changeBackgroundText1(color: Int) {
        editText.setBackgroundColor(color)
        editText.setTextColor(Color.WHITE)
    }

    private var myAM: ActionMode? = null
    fun setNavigationButtons() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        navView.setNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.drawer_button1 -> startActivity(Intent(this, MainActivity::class.java))
                R.id.drawer_button2 -> startActivity(Intent(this, Activity2::class.java))
//                R.id.drawer_button3 -> startActivity(Intent(this, Activity3::class.java))
            }

            true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)
        editText = findViewById(R.id.editTextText_activity3)

        val myAMCallback: ActionMode.Callback = object: ActionMode.Callback
        {
            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                mapEditText.forEach{
                    menu?.add(0, it.key, 0, it.value.first)
                }
                return true
            }

            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                return true
            }

            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                if(mapEditText.containsKey(item!!.itemId)) {
                    mapEditText[item.itemId]?.let { changeBackgroundText1(it.second) }
                }
                return true
            }

            override fun onDestroyActionMode(mode: ActionMode?) {
                myAM = null
            }

        }

        editText.setOnLongClickListener(View.OnLongClickListener { view ->
            // Called when the user long-clicks on someView
            if (myAM != null) {
                return@OnLongClickListener false
            }
            // Start the CAB using the ActionMode.Callback defined above
            myAM = startActionMode(myAMCallback)
            //.maybe some more job
            true
        })

//        setNavigationButtons()
    }
}