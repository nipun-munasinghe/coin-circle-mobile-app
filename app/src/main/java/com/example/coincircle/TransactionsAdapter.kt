import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coincircle.R
import com.example.coincircle.Transaction

class TransactionsAdapter(private val transactions: List<Transaction>) : RecyclerView.Adapter<TransactionsAdapter.TransactionViewHolder>() {

    inner class TransactionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val groupName: TextView = itemView.findViewById(R.id.groupName)
        val expense: TextView = itemView.findViewById(R.id.expense)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_transaction, parent, false)
        return TransactionViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction = transactions[position]
        holder.groupName.text = transaction.groupName
        holder.expense.text = transaction.expenseAmount
    }

    override fun getItemCount() = transactions.size
}
