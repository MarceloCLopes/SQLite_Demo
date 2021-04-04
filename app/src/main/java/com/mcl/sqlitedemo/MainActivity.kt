package com.mcl.sqlitedemo

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val helper = MyDBHelper(applicationContext)
        val db = helper.readableDatabase
        /*val rs = db.rawQuery("SELECT * FROM USERS", null)

        if (rs.moveToNext()){
            Toast.makeText(applicationContext, rs.getString(1), Toast.LENGTH_LONG).show()
        }*/

        btnInsert.setOnClickListener {
            val contentValue = ContentValues()
            contentValue.put("USERNAME", editTextEmail.text.toString())
            contentValue.put("PASSWORD", editTextPassword.text.toString())
            db.insert("USERS", null, contentValue)

            editTextEmail.setText("")
            editTextPassword.setText("")
            editTextEmail.requestFocus()
        }
    }
}