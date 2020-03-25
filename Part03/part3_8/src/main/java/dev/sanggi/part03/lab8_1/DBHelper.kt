package dev.sanggi.part03.lab8_1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, "memodb", null, 1) {

    private val DATABASE_VERSION = 1

    override fun onCreate(db: SQLiteDatabase) {
        val memoSQL = "create table tb_memo (" +
                "_id integer primary key autoincrement," +
                "title," +
                "content)"
        db.execSQL(memoSQL)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if(newVersion == DATABASE_VERSION) {
            db.execSQL("drop table tb_memo")
            onCreate(db)
        }
    }

}