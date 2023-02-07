package islom.din.dodo_ilmhona_proskills.QA.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.QA.data.Pizza
import islom.din.dodo_ilmhona_proskills.databinding.InterestingItemBinding
import islom.din.dodo_ilmhona_proskills.QA.diffUtils.PizzaDiffUtls

class InterestingAdapter : ListAdapter<Pizza, InterestingAdapter.InterestingViewHolder>(
    PizzaDiffUtls()
) {

    inner class InterestingViewHolder(itemView: View) : ViewHolder(itemView){
        var binding = InterestingItemBinding.bind(itemView)
        var image = binding.image
        var pizzaName = binding.pizzaName
        var pizzaPrice = binding.pizzaPrice

        fun bind(pizza: Pizza){
            image.setImageResource(pizza.image)
            pizzaName.text = pizza.name
            pizzaPrice.text = pizza.formatPriceFrom()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InterestingViewHolder {
        return InterestingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.interesting_item,parent,false))
    }

    override fun onBindViewHolder(holder: InterestingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}