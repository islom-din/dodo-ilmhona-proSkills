package islom.din.dodo_ilmhona_proskills.QA.adapter

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

class PizzaAdapter() : ListAdapter<Pizza,ViewHolder>(PizzaDiffUtls()) {

    var onClick : ((Pizza) -> Unit)? = null
    var order : ((Pizza) -> Unit)? = null

    inner class PizzaMainViewHolder(itemView: View)  : ViewHolder(itemView) {
        private var binding = PizzaItemMainBinding.bind(itemView)

        fun bind(pizzaData: Pizza) {
            binding.pizzaImage.setImageResource(pizzaData.image)
            binding.pizzaName.text = pizzaData.name
            binding.pizzaAbout.text = pizzaData.about
            binding.piccaPrice.text = pizzaData.formatPrice()

            binding.piccaPrice.setOnClickListener {
                order?.invoke(pizzaData)
            }

        }
    }

    inner class PizzaViewHolder(itemView: View) : ViewHolder(itemView) {
        private var binding = PizzaItemBinding.bind(itemView)

        fun bind(pizzaData: Pizza){
            binding.pizzaImage.setImageResource(pizzaData.image)
            binding.pizzaName.text = pizzaData.name
            binding.pizzaAbout.text = pizzaData.about
            binding.piccaPrice.text = pizzaData.formatPrice()
            binding.piccaPrice.setOnClickListener {
                order?.invoke(pizzaData)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).main) PIZZAMAIN else PIZZA
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == PIZZA) PizzaViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.pizza_item,parent,false))
        else PizzaMainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.pizza_item_main,parent,false))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is PizzaMainViewHolder)
            holder.bind(getItem(position))
        else if (holder is PizzaViewHolder)
            holder.bind(getItem(position))
    }
    companion object {
        const val PIZZAMAIN = 0
        const val PIZZA = 1
    }
}