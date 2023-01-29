package islom.din.dodo_ilmhona_proskills.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.data.Pizza
import islom.din.dodo_ilmhona_proskills.databinding.PizzaItemBinding
import islom.din.dodo_ilmhona_proskills.diffUtils.PizzaDiffUtls

class PizzaAdapter : ListAdapter<Pizza,PizzaAdapter.PizzaViewHolder>(PizzaDiffUtls()) {

    inner class PizzaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var binding = PizzaItemBinding.bind(itemView)

        fun bind(pizzaData: Pizza){
            binding.pizzaImage.setImageResource(pizzaData.image)
            binding.pizzaName.text = pizzaData.name
            binding.pizzaAbout.text = pizzaData.about
            binding.piccaPrice.text = pizzaData.formatPrice()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        return PizzaViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.pizza_item,parent,false))
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}