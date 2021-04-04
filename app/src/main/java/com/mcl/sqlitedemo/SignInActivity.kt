package com.mcl.sqlitedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val helper = MyDBHelper(applicationContext)
        val db = helper.readableDatabase

        btnSignIn.setOnClickListener {
            val args = listOf<String>(
                editEmail.text.toString(),
                editPassword.text.toString()
            ).toTypedArray()

            val rs = db.rawQuery("SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?", args)

            if (rs.moveToNext()){
                Toast.makeText(applicationContext, "Welcome to Access", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext, "Invalid Credential", Toast.LENGTH_LONG).show()
            }
        }
    }
}