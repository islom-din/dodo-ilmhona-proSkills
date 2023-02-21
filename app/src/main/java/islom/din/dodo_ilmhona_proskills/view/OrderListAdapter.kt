package islom.din.dodo_ilmhona_proskills.view.profil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.order.Pizza
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.databinding.ItemHistoryOrderBinding


class OrderListAdapter:ListAdapter<Pizza,OrderListAdapter.OrderViewHolder>(OrderDiffUnits()) {
    inner class OrderViewHolder(itemView: View):ViewHolder(itemView){
        val binding = ItemHistoryOrderBinding.bind(itemView)

        fun bind(pizza: Pizza){
            if (adapterPosition==0){
                binding.titteTextOrders.visibility = View.VISIBLE
                binding.oderImge.setImageResource(pizza.image)
                binding.orderName.text=pizza.name
                binding.orderProperties.text=pizza.name
                binding.orderPrice.text= pizza.price.toString()
            }

            binding.oderImge.setImageResource(pizza.image)
            binding.orderName.text=pizza.name
            binding.orderProperties.text=pizza.name
            binding.orderPrice.text= pizza.price.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
      return OrderViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_history_order,parent,false))
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
       holder.bind(getItem(position))
    }
}
class OrderDiffUnits:DiffUtil.ItemCallback<Pizza>() {
    override fun areItemsTheSame(oldItem: Pizza, newItem: Pizza) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Pizza, newItem: Pizza) = oldItem == newItem
}