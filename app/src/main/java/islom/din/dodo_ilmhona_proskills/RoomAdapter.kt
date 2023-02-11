package islom.din.dodo_ilmhona_proskills

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import islom.din.dodo_ilmhona_proskills.databinding.RoomItemBinding
import islom.din.dodo_ilmhona_proskills.db.MPizza

class RoomAdapter : ListAdapter<MPizza,RoomAdapter.RoomViewHolder>(RoomDiffUtils()) {

    inner class RoomViewHolder(itemView: View) : ViewHolder(itemView){
        private val binding = RoomItemBinding.bind(itemView)

        fun bind(mPizza: MPizza){
            binding.name.text = mPizza.name
            binding.price.text = mPizza.price.toString()
        }
    }

    class RoomDiffUtils : DiffUtil.ItemCallback<MPizza>() {
        override fun areItemsTheSame(oldItem: MPizza, newItem: MPizza): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MPizza, newItem: MPizza): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        return RoomViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.room_item,parent,false))
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}