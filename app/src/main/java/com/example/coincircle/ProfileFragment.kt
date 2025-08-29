package com.example.coincircle

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ProfileFragment : Fragment() {
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
        // Inflate the layout
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Find the logout ImageView by ID
        val logoutImageView = view.findViewById<ImageView>(R.id.logout)
        val summaryTxt = view.findViewById<TextView>(R.id.summaryTxt)
        val cardDetailsTxt = view.findViewById<LinearLayout>(R.id.cardDetails)

        // Set click listener to navigate to LoginActivity
        logoutImageView.setOnClickListener {
            val intent = Intent(requireActivity(), LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

        summaryTxt.setOnClickListener {
            val intent = Intent(requireActivity(), AccountSummaryActivity::class.java)
            startActivity(intent)
        }

        cardDetailsTxt.setOnClickListener {
            val intent = Intent(requireActivity(), CardDetailsActivity::class.java)
            startActivity(intent)
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
