package islom.din.dodo_ilmhona_proskills.paging.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.QA.data.Pizza
import islom.din.dodo_ilmhona_proskills.databinding.PizzaItemBinding
import islom.din.dodo_ilmhona_proskills.databinding.PizzaItemMainBinding
import islom.din.dodo_ilmhona_proskills.QA.diffUtils.PizzaDiffUtls
import islom.din.dodo_ilmhona_proskills.khq.dbMain.Products

class ProductAdapter() : ListAdapter<Products, ProductAdapter.PizzaViewHolder>(ProductDiffUtls()) {

    var onClick : ((Products) -> Unit)? = null
    var order : ((Products) -> Unit)? = null

    inner class PizzaViewHolder(itemView: View) : ViewHolder(itemView) {
        private var binding = PizzaItemBinding.bind(itemView)

        fun bind(pizzaData: Products){
            binding.pizzaImage.setImageResource(pizzaData.image)
            binding.pizzaName.text = pizzaData.name
            binding.pizzaAbout.text = pizzaData.about
            binding.piccaPrice.text = pizzaData.formatPrice()
            binding.piccaPrice.setOnClickListener {
                order?.invoke(pizzaData)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        return PizzaViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.pizza_item,parent,false))
    }
    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}