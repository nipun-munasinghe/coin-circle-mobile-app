package com.example.coincircle

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class GroupDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_details)

        val transactionsContainer = findViewById<LinearLayout>(R.id.transactionsContainer)
        val groupBalanceAmount = findViewById<TextView>(R.id.currentBalanceAmount)

        // Set group balance (example)
        groupBalanceAmount.text = "5,660.00"

        // Example transactions list
        val transactions = listOf(
            TransactionDetail("Weekly Collection", "Chanindu Isuranga", "20:33", "Aug 24 Mon", "1000.00 LKR"),
            TransactionDetail("4 cups of coffee", "Nipun Lakmal", "19:12", "Aug 23 Sun", "-600.00 LKR"),
            TransactionDetail("Weekly Collection", "Moditha Neranjan", "18:50", "Aug 24 Mon", "1000.00 LKR"),
            TransactionDetail("Weekly Collection", "Thimira Thathsarana", "17:33", "Aug 24 Mon", "1000.00 LKR"),
            TransactionDetail("For lunch", "Chanindu Isuranga", "13:53", "Aug 23 Sun", "-1850.00 LKR"),
            TransactionDetail("For a cool drink", "Thimira Thathsarana", "10:55", "Aug 23 Sun", "-450.00 LKR"),
            TransactionDetail("For some snacks", "Sandaru Heshan", "16:15", "Aug 22 Sat", "-640.00 LKR"),
            TransactionDetail("Weekly Collection", "Nipun Lakmal", "20:47", "Aug 21 Fri", "1000.00 LKR")
        )

        val inflater = layoutInflater
        transactions.forEach { tx ->
            val txView = inflater.inflate(R.layout.item_transaction_group, transactionsContainer, false)
            txView.findViewById<TextView>(R.id.description).text = tx.description
            txView.findViewById<TextView>(R.id.subInfo).text = tx.subInfo
            txView.findViewById<TextView>(R.id.time).text = tx.time
            txView.findViewById<TextView>(R.id.date).text = tx.date
            txView.findViewById<TextView>(R.id.amount).text = tx.amount
            transactionsContainer.addView(txView)
        }

        val backBtn = findViewById<ImageView>(R.id.backBtn)
        backBtn.setOnClickListener {
            val intent = Intent(this, GroupsFragment::class.java)
            finish()
        }

        val deleteBtn = findViewById<ImageView>(R.id.deleteGroupBtn)
        deleteBtn.setOnClickListener {
            showDeleteDialog()
        }

        val addTransactionBtn = findViewById<ImageView>(R.id.addTransactionBtn)
        addTransactionBtn.setOnClickListener {
            showAddTransactionDialog()
        }

        val addFriend = findViewById<ImageView>(R.id.addMemberBtn)
        addFriend.setOnClickListener {
            showAddFriendDialog()
        }
    }

    private fun showDeleteDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_delete_group, null)
        val alertDialog = AlertDialog.Builder(this, R.style.DialogTheme)
            .setView(dialogView)
            .setCancelable(true)
            .create()

        // Handle delete confirmation button
        dialogView.findViewById<Button>(R.id.deleteBtn).setOnClickListener {
            // Your delete logic here (e.g., finish, remove group, etc.)
            alertDialog.dismiss()
            finish()
        }

        alertDialog.show()
    }

    private fun showAddTransactionDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_transaction, null)
        val alertDialog = AlertDialog.Builder(this, R.style.DialogTheme)
            .setView(dialogView)
            .setCancelable(true)
            .create()

        val titleEdit = dialogView.findViewById<android.widget.EditText>(R.id.transactionTitleEdit)
        val amountEdit = dialogView.findViewById<android.widget.EditText>(R.id.transactionAmountEdit)
        val okBtn = dialogView.findViewById<Button>(R.id.okBtn)

        okBtn.setOnClickListener {
            val title = titleEdit.text.toString().trim()
            val amount = amountEdit.text.toString().trim()

            alertDialog.dismiss()
        }

        alertDialog.show()
    }

    private fun showAddFriendDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_friend, null)
        val alertDialog = AlertDialog.Builder(this, R.style.DialogTheme)
            .setView(dialogView)
            .setCancelable(true)
            .create()

        val emailEdit = dialogView.findViewById<EditText>(R.id.emailEdit)
        val nickNameEdit = dialogView.findViewById<EditText>(R.id.nickNameEdit)
        val addFriendBtn = dialogView.findViewById<Button>(R.id.addFriendBtn)

        addFriendBtn.setOnClickListener {
            val email = emailEdit.text.toString().trim()
            val nickname = nickNameEdit.text.toString().trim()

            alertDialog.dismiss()
        }

        alertDialog.show()
    }
}