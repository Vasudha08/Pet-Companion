package com.example.pet

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 2
        private const val DATABASE_NAME = "pet"
        private const val TABLE_NAME_LOGIN = "login"
        private const val TABLE_NAME_LOGS = "logs"
        private const val COLUMN_ID = "id"
        private const val COLUMN_USERNAME = "username"
        private const val COLUMN_PASSWORD = "password"
        private const val COLUMN_LOG_NAME = "log_name"
        private const val COLUMN_DATE = "date"
        private const val COLUMN_DETAILS = "details"
        private const val COLUMN_LOG_CATEGORY = "log_category"
    }

    override fun onCreate(db: SQLiteDatabase) {


        val CREATE_TABLE_LOGS = ("CREATE TABLE $TABLE_NAME_LOGS ($COLUMN_ID INTEGER PRIMARY KEY, "
                + "$COLUMN_LOG_NAME TEXT,"
                + "$COLUMN_DATE TEXT,"
                + "$COLUMN_DETAILS TEXT,"
                + "$COLUMN_LOG_CATEGORY TEXT)")
        db.execSQL(CREATE_TABLE_LOGS)

        val CREATE_TABLE_LOGIN = ("CREATE TABLE $TABLE_NAME_LOGIN ($COLUMN_ID INTEGER PRIMARY KEY, "
                + "$COLUMN_USERNAME TEXT,"
                + "$COLUMN_PASSWORD TEXT)")
        db.execSQL(CREATE_TABLE_LOGIN)


    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME_LOGIN")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME_LOGS")
        onCreate(db)
    }

    fun addUser(username: String, password: String): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_USERNAME, username)
        values.put(COLUMN_PASSWORD, password)
        return db.insert(TABLE_NAME_LOGIN, null, values)
    }

    fun getUser(username: String, password: String): Boolean {
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME_LOGIN WHERE $COLUMN_USERNAME=? AND $COLUMN_PASSWORD=?"
        val cursor = db.rawQuery(query, arrayOf(username, password))
        return cursor.moveToFirst()
    }

    fun addLog(logName: String, date: String, details: String, logCategory: String): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_LOG_NAME, logName)
        values.put(COLUMN_DATE, date)
        values.put(COLUMN_DETAILS, details)
        values.put(COLUMN_LOG_CATEGORY, logCategory)
        return db.insert(TABLE_NAME_LOGS, null, values)
    }

    // Method to retrieve logs
    fun getLogs(): Cursor? {
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME_LOGS"
        return db.rawQuery(query, null)
    }

    // Add methods for updating, deleting, and other operations as needed
}
