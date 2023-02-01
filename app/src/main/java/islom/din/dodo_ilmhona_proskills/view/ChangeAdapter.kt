package islom.din.dodo_ilmhona_proskills.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.databinding.ComboDezignBinding
import islom.din.dodo_ilmhona_proskills.databinding.ItemRecyclerSousViewBinding
import islom.din.dodo_ilmhona_proskills.model.ChangeData

class ChangeAdapter:ListAdapter<ChangeData,ChangeAdapter.ChangeViewHolder>(ChangDiffutils()) {
    var onClickItem:((ChangeData)->Unit)? = null

    inner class ChangeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ComboDezignBinding.bind(itemView)

        init {
            binding.root.setOnClickListener {
                onClickItem?.invoke(getItem(adapterPosition))
            }
        }

        fun bind(changeData: ChangeData){
            binding.changeButton.text =changeData.button
            binding.imageComboDezign.setImageResource(changeData.img)
            binding.nameComboDezign.text = changeData.name
            binding.descriptionComboDezig.text = changeData.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChangeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.combo_dezign,parent,false)
        return ChangeViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChangeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ChangDiffutils :DiffUtil.ItemCallback<ChangeData>() {
    override fun areItemsTheSame(oldItem: ChangeData, newItem: ChangeData):Boolean =  oldItem.id == newItem.id
    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: ChangeData, newItem: ChangeData): Boolean =  oldItem == newItem
}