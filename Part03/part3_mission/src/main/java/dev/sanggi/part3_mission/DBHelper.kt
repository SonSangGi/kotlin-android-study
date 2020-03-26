package dev.sanggi.part3_mission

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, "memodb", null, 1) {

    private val DATABASE_VERSION = 1

    override fun onCreate(db: SQLiteDatabase) {
        val memoSQL = "create table tb_contact (" +
                "_id integer primary key autoincrement," +
                "name not null," +
                "phone," +
                "email)"
        db.execSQL(memoSQL)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if(newVersion == DATABASE_VERSION) {
            db.execSQL("drop table tb_contact")
            onCreate(db)
        }
    }

}