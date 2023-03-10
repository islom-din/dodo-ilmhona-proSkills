package islom.din.dodo_ilmhona_proskills.paging.adapter

import androidx.recyclerview.widget.DiffUtil
import islom.din.dodo_ilmhona_proskills.QA.data.Pizza
import islom.din.dodo_ilmhona_proskills.khq.dbMain.Products

class ProductDiffUtls : DiffUtil.ItemCallback<Products>() {
    override fun areItemsTheSame(oldItem: Products, newItem: Products): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Products, newItem: Products): Boolean {
        return oldItem == newItem
    }
}