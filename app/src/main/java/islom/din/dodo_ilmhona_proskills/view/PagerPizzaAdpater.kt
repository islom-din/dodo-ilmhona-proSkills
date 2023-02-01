package islom.din.dodo_ilmhona_proskills.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.databinding.PagerPizzaBinding
import islom.din.dodo_ilmhona_proskills.model.ChangeData

class PagerPizzaAdpater:ListAdapter<ChangeData,PagerPizzaAdpater.PagerViewHolder>(PagerDiffutils()) {

    class PagerViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val binding = PagerPizzaBinding.bind(itemView)
        fun bind(changeData: ChangeData){
            binding.description.text = changeData.description
            binding.image.setImageResource(changeData.img)
            binding.name.text = changeData.name

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        return PagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.pager_pizza,parent,false))
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class PagerDiffutils :DiffUtil.ItemCallback<ChangeData>() {
    override fun areItemsTheSame(oldItem: ChangeData, newItem: ChangeData):Boolean =  oldItem.id == newItem.id
    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: ChangeData, newItem: ChangeData): Boolean =  oldItem == newItem
}