package com.example.mobilebankingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TransferAdapter(private val transferList: List<HashMap<String, String>>) :
    RecyclerView.Adapter<TransferAdapter.TransferViewHolder>() {

    class TransferViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val senderTextView: TextView = itemView.findViewById(R.id.senderhis)
        val receiverTextView: TextView = itemView.findViewById(R.id.receiverhis)
        val amountTextView: TextView = itemView.findViewById(R.id.amounthis)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransferViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_history, parent, false)
        return TransferViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TransferViewHolder, position: Int) {
        val transfer = transferList[position]
        holder.senderTextView.text = transfer["sender"]
        holder.receiverTextView.text = transfer["receiver"]
        holder.amountTextView.text = transfer["amount"]
    }

    override fun getItemCount(): Int {
        return transferList.size
    }
}