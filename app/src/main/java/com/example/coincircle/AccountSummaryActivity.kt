package com.example.coincircle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AccountSummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_summary)

        val groups = listOf(
            TransactionGroup("Uni gang", "1,500.00 LKR"),
            TransactionGroup("Fighters", "-700.00 LKR"),
            TransactionGroup("Car gang", "00.00 LKR"),
            TransactionGroup("We 4", "-1,000.00 LKR"),
            TransactionGroup("Our Society", "1,890.00 LKR"),
            TransactionGroup("Brothers", "-640.00 LKR"),
            TransactionGroup("We 4", "-1,000.00 LKR"),
            TransactionGroup("Our Society", "1,890.00 LKR"),
            TransactionGroup("School Leavers", "400.00 LKR")
        )

        val transactions = listOf(
            LatestTransaction("Paid Rs.1,000 to Uni gang", "2 days ago"),
            LatestTransaction("Paid Rs.600 to Fighters", "4 days ago"),
            LatestTransaction("Paid Rs.1,000 to Car gang", "5 days ago"),
            LatestTransaction("Paid Rs.1,000 to We 4", "5 days ago"),
            LatestTransaction("Paid Rs.1,800 to Our Society", "7 days ago"),
            LatestTransaction("Paid Rs.1,000 to We 4", "5 days ago")
        )

        val groupRecycler = findViewById<RecyclerView>(R.id.groupBalancesRecycler)
        val latestRecycler = findViewById<RecyclerView>(R.id.latestTransactionsRecycler)

        groupRecycler.layoutManager = LinearLayoutManager(this)
        latestRecycler.layoutManager = LinearLayoutManager(this)

        groupRecycler.adapter = GroupBalancesAdapter(groups)
        latestRecycler.adapter = LatestTransactionsAdapter(transactions)

        val totalPayable = findViewById<TextView>(R.id.totalPayable)
        totalPayable.text = "Total payable: 3,790.00 LKR"

        val backBtn = findViewById<ImageView>(R.id.backBtn)
        backBtn.setOnClickListener {
            val intent = Intent(this, ProfileFragment::class.java)
            finish()
        }
    }
}
