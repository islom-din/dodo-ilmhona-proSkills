package islom.din.dodo_ilmhona_proskills.view

import androidx.recyclerview.widget.DiffUtil
import islom.din.dodo_ilmhona_proskills.model.Sous

class MyDiffUtil:DiffUtil.ItemCallback<Sous>() {
    override fun areItemsTheSame(oldItem: Sous, newItem: Sous) :Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Sous, newItem: Sous):Boolean = oldItem == newItem
}