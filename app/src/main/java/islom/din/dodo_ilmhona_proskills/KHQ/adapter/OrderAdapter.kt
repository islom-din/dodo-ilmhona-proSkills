package islom.din.dodo_ilmhona_proskills.KHQ.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import islom.din.dodo_ilmhona_proskills.KHQ.dbMain.Products
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.databinding.ItemKorzinaBinding

class OrderAdapter() : ListAdapter<Products,OrderAdapter.OrderViewHolder>(OrderDiffUtils()) {

    var updateAmount : ((Int,Int) -> Unit)? = null

    inner class OrderViewHolder(itemView: View) : ViewHolder(itemView){
        var binding = ItemKorzinaBinding.bind(itemView)

        fun bind(products: Products){
            binding.korzinaItemImage.setImageResource(products.image)
            binding.korzinaItemTitle.text = products.name
            binding.korzinaItemTotal.text = products.price.toString()
            binding.korzinaItemDescription.text = products.about
            binding.korzinaItemAmount.text = "1"

            var amount = binding.korzinaItemAmount.text.toString().toInt()

            binding.korzinaCountDelete.setOnClickListener {
                if (amount > 1) {
                    amount--
                    binding.korzinaItemAmount.text = amount.toString()
                    updateAmount?.invoke(products.id,amount)
                }
            }
            binding.korzinaCountAdd.setOnClickListener {
                amount++
                binding.korzinaItemAmount.text = amount.toString()
                updateAmount?.invoke(products.id,amount)
            }
        }
    }
    companion object {
        class OrderDiffUtils : DiffUtil.ItemCallback<Products>(){
            override fun areItemsTheSame(oldItem: Products, newItem: Products): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Products, newItem: Products): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        return OrderViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_korzina,parent,false))
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}