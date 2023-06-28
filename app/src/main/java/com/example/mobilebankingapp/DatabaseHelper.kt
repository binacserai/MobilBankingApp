package com.example.mobilebankingapp



import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "moneytransfer.db"
        private const val DATABASE_VERSION = 1

        private const val TABLE_NAME = "transfers"
        private const val COLUMN_ID = "id"
        private const val COLUMN_SENDER = "sender"
        private const val COLUMN_RECEIVER = "receiver"
        private const val COLUMN_AMOUNT = "amount"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_SENDER TEXT, $COLUMN_RECEIVER TEXT, $COLUMN_AMOUNT TEXT)"
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dropTableQuery = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(dropTableQuery)
        onCreate(db)
    }

    fun saveTransfer(sender: String, receiver: String, amount: String): Long {
        val values = ContentValues()
        values.put(COLUMN_SENDER, sender)
        values.put(COLUMN_RECEIVER, receiver)
        values.put(COLUMN_AMOUNT, amount)

        val db = writableDatabase
        val id = db.insert(TABLE_NAME, null, values)
        db.close()

        return id
    }
    fun getAllTransfers(): List<HashMap<String, String>> {
        val transferList = mutableListOf<HashMap<String, String>>()
        val selectQuery = "SELECT * FROM $TABLE_NAME"

        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            val columnNames = cursor.columnNames.toList()

            do {
                val transfer = HashMap<String, String>()
                for (columnName in columnNames) {
                    val columnIndex = cursor.getColumnIndex(columnName)
                    if (columnIndex >= 0) {
                        val value = cursor.getString(columnIndex)
                        transfer[columnName] = value
                    }
                }
                transferList.add(transfer)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()

        return transferList
    }


}


