package com.mcl.sqlitedemo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context: Context) : SQLiteOpenHelper(
    context,
    "USERDB",
    null,
    1
) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE USERS(" +
                    "USERID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "USERNAME TEXT," +
                    "PASSWORD TEXT)"
        )
        db?.execSQL("INSERT INTO USERS(username, password) VALUES('marc01@gmail.com', 'pcs')")
        db?.execSQL("INSERT INTO USERS(username, password) VALUES('marc.mcl@hotmail.com', '123')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}