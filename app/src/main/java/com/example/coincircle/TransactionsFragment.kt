import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coincircle.R
import com.example.coincircle.Transaction

class TransactionsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TransactionsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_transactions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.transactionsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val transactionsList = listOf(
            Transaction("Uni gang", "1,000.00 LKR"),
            Transaction("Fighters", "600.00 LKR"),
            Transaction("Car gang", "1,000.00 LKR"),
            Transaction("We 4", "1,000.00 LKR"),
            Transaction("Our Society", "1,850.00 LKR"),
            Transaction("School Leavers", "450.00 LKR"),
            Transaction("Brothers", "640.00 LKR"),
            Transaction("Family", "1,000.00 LKR"),
            Transaction("Church Team", "1,000.00 LKR"),
            Transaction("Uni gang", "1,000.00 LKR"),
            Transaction("Fighters", "600.00 LKR"),
            Transaction("Car gang", "1,000.00 LKR"),
            Transaction("We 4", "1,000.00 LKR"),
            Transaction("Our Society", "1,850.00 LKR"),
            Transaction("School Leavers", "450.00 LKR"),
            Transaction("Brothers", "640.00 LKR"),
            Transaction("Family", "1,000.00 LKR"),
            Transaction("Church Team", "1,000.00 LKR")
        )
        adapter = TransactionsAdapter(transactionsList)
        recyclerView.adapter = adapter
    }
}
