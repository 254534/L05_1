package com.example.l05_1

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.EditText
import android.widget.Toast
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
        navView.menu.getItem(2).isChecked = true

        navView.setNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.drawer_button1 -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    this.onBackPressed()
                }
                R.id.drawer_button2 -> {
                    startActivity(Intent(this, Activity2::class.java))
                    this.onBackPressed()
                }
//                R.id.drawer_button3 -> startActivity(Intent(this, Activity3::class.java))
            }

            true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)
        editText = findViewById(R.id.editTextText_activity3)
        val editText2: EditText = findViewById(R.id.activity3_editText2)
        registerForContextMenu(editText2)

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

        setNavigationButtons()
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (menu != null) {
            menuInflater.inflate(R.menu.activity3_text2_menu, menu)
            menu.getItem(0).isChecked = isBold
            menu.getItem(1).isChecked = isItalic
        }
    }
    private var isBold: Boolean = false
    private var isItalic: Boolean = false

    fun updateEditText2(){
        val editText2: EditText = findViewById(R.id.activity3_editText2)
        if(isBold && isItalic) {
            editText2.typeface = Typeface.defaultFromStyle(Typeface.BOLD_ITALIC)
        }
        else if(isBold) {
            editText2.typeface = Typeface.DEFAULT_BOLD
        }
        else if(isItalic) {
            editText2.typeface = Typeface.defaultFromStyle(Typeface.ITALIC)
        }
        else {
            editText2.typeface = Typeface.DEFAULT
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
//        Toast.makeText(this, "${item.itemId}  ${R.id.activity3_editText2_item1}", Toast.LENGTH_LONG).show()

        when (item.itemId) {
            R.id.activity3_editText2_item1 -> {
                item.isChecked = !item.isChecked
                isBold = item.isChecked
                updateEditText2()
                return true
            }
            R.id.activity3_editText2_item2 -> {
                item.isChecked = !item.isChecked
                isItalic = item.isChecked
                updateEditText2()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }

}