package com.example.mobilebankingapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class history:AppCompatActivity (){


    private lateinit var transferRecyclerView: RecyclerView
    private lateinit var transferAdapter: TransferAdapter
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        supportActionBar?.hide()
        transferRecyclerView = findViewById(R.id.transferRecyclerView)
        transferRecyclerView.layoutManager = LinearLayoutManager(this)

        val transferList = getTransferListFromDatabase()
        transferAdapter = TransferAdapter(transferList)
        transferRecyclerView.adapter = transferAdapter
    }

    private fun getTransferListFromDatabase(): List<HashMap<String, String>> {
        val databaseHelper = DatabaseHelper(this)
        return databaseHelper.getAllTransfers()
    }
}