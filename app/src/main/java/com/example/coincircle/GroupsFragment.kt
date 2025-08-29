package com.example.coincircle

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.cardview.widget.CardView

class GroupsFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_groups, container, false)

        // Card nav to details
        val uniGangCard = view.findViewById<CardView>(R.id.uniGang)
        uniGangCard.setOnClickListener {
            val intent = Intent(requireContext(), GroupDetailsActivity::class.java)
            startActivity(intent)
        }

        // Show Create Group dialog
        val createGroupIcon = view.findViewById<View>(R.id.createGroup)
        createGroupIcon.setOnClickListener {
            showCreateGroupDialog()
        }

        return view
    }

    private fun showCreateGroupDialog() {
        val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_create_group, null)
        val alertDialog = AlertDialog.Builder(requireContext(), R.style.DialogTheme)
            .setView(dialogView)
            .setCancelable(true)
            .create()

        val groupNameEdit = dialogView.findViewById<EditText>(R.id.groupNameEdit)
        val addFriendsEdit = dialogView.findViewById<EditText>(R.id.addFriendsEdit)
        val createBtn = dialogView.findViewById<Button>(R.id.createBtn)

        createBtn.setOnClickListener {
            val groupName = groupNameEdit.text.toString().trim()
            val friends = addFriendsEdit.text.toString().trim()

            alertDialog.dismiss()
        }

        alertDialog.show()
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GroupsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}