package islom.din.dodo_ilmhona_proskills.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.databinding.PagerPizzaBinding
import islom.din.dodo_ilmhona_proskills.model.Pizza




class PagerPizzaAdpater : ListAdapter<Pizza, PagerPizzaAdpater.PagerViewHolder>(
    object : DiffUtil.ItemCallback<Pizza>() {
        override fun areItemsTheSame(oldItem: Pizza, newItem: Pizza): Boolean =
            oldItem.id == newItem.id

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Pizza, newItem: Pizza): Boolean =
            oldItem == newItem
    }
) {

    var onSelectItem: ((Pizza) -> (Unit))? = null

    inner class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = PagerPizzaBinding.bind(itemView)
        fun bind(changeData: Pizza) {
            binding.description.text = changeData.about
            binding.image.setImageResource(changeData.image)
            binding.name.text = changeData.name
        }

        init {
            binding.root.setOnClickListener {
                onSelectItem?.invoke(getItem(adapterPosition))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        return PagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.pager_pizza,parent,false))
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

