package islom.din.dodo_ilmhona_proskills.QA.diffUtils

import androidx.recyclerview.widget.DiffUtil
import islom.din.dodo_ilmhona_proskills.QA.data.Category

class CategoryDiffUtils : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.isChecked == newItem.isChecked
    }
}