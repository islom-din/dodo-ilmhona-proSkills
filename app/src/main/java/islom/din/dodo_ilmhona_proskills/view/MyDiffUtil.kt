package islom.din.dodo_ilmhona_proskills.view

import androidx.recyclerview.widget.DiffUtil

import islom.din.dodo_ilmhona_proskills.data.Vkus

class MyDiffUtil:DiffUtil.ItemCallback<Vkus>() {
    override fun areItemsTheSame(oldItem: Vkus, newItem: Vkus): Boolean = oldItem== newItem

    override fun areContentsTheSame(oldItem: Vkus, newItem: Vkus):Boolean = oldItem == newItem
}

