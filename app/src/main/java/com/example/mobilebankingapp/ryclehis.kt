package com.example.mobilebankingapp

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobilebankingapp.DatabaseHelper

import androidx.recyclerview.widget.RecyclerView

class ryclehis:AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var transferAdapter: TransferAdapter
    private var transferList: List<HashMap<String, String>>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ryclehis)

        supportActionBar?.hide()
        transferList = getTransferList(this)

        recyclerView = findViewById(R.id.transferRecyclerView)
        transferAdapter = TransferAdapter(transferList!!)

        recyclerView.adapter = transferAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
private fun getTransferList(context: Context): List<HashMap<String, String>> {
    val transferList = mutableListOf<HashMap<String, String>>()

    val databaseHelper = DatabaseHelper(context)
    val transfers = databaseHelper.getAllTransfers()

    for (transfer in transfers) {
        val transferData = hashMapOf(
            "sender" to (transfer["sender"] ?: ""),
            "receiver" to (transfer["receiver"] ?: ""),
            "amount" to (transfer["amount"] ?: "")
        )
        transferList.add(transferData)
    }

    return transferList
}

