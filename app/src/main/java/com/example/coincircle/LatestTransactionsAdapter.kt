package com.example.coincircle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LatestTransactionsAdapter(private val transactions: List<LatestTransaction>) :
    RecyclerView.Adapter<LatestTransactionsAdapter.TransViewHolder>() {

    inner class TransViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val detail: TextView = itemView.findViewById(R.id.transactionDetail)
        val timeAgo: TextView = itemView.findViewById(R.id.transactionTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_latest_transaction, parent, false)
        return TransViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransViewHolder, position: Int) {
        val item = transactions[position]
        holder.detail.text = item.detail
        holder.timeAgo.text = item.timeAgo
    }

    override fun getItemCount() = transactions.size
}
