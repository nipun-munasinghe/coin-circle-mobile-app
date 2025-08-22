package com.example.coincircle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GroupBalancesAdapter(private val groups: List<TransactionGroup>) :
    RecyclerView.Adapter<GroupBalancesAdapter.GroupViewHolder>() {

    inner class GroupViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val groupName: TextView = itemView.findViewById(R.id.groupName)
        val balance: TextView = itemView.findViewById(R.id.balanceAmount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_group_balance, parent, false)
        return GroupViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        val item = groups[position]
        holder.groupName.text = item.groupName
        holder.balance.text = item.balance
    }

    override fun getItemCount() = groups.size
}
