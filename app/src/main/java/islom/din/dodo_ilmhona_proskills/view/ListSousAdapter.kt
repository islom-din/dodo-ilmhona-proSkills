package islom.din.dodo_ilmhona_proskills.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import islom.din.dodo_ilmhona_proskills.Constants
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.data.Vkus
import islom.din.dodo_ilmhona_proskills.databinding.ItemRecyclerSousViewBinding


class ListSousAdapter : ListAdapter<Vkus, ListSousAdapter.SousViewHolder>(MyDiffUtil()) {
    var onClick: ((Int) -> Unit) = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SousViewHolder {
        return SousViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_recycler_sous_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SousViewHolder, position: Int) {
        holder.bindImage(getItem(position))
        holder.bindText(getItem(position))
        holder.bindSena(getItem(position))

    }

    inner class SousViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemRecyclerSousViewBinding.bind(itemView)
        fun bindImage(vkus: Vkus) {
            binding.imageSous.setImageResource(vkus.image)

            binding.root.setOnClickListener() {
                onClick.invoke(adapterPosition)
                vkus.select = true
                showChecked(vkus)

                showHide(binding.selectImage)
                showHide(binding.seconClock)

            }
            binding.seconClock.setOnClickListener() {
                vkus.select = false
                showChecked(vkus)
                showHide(binding.seconClock)
                showHide(binding.selectImage)
            }

        }


        fun bindText(vkus: Vkus) {
            binding.sousName.text = vkus.name
        }

        fun bindSena(vkus: Vkus) {
            binding.sena.text = vkus.price[Constants.MALENKAYA].toString()
        }

        fun showHide(view: View) {
            view.visibility = if (view.visibility == View.VISIBLE) {
                View.INVISIBLE
            } else {
                View.VISIBLE
            }
        }

        fun showChecked(vkus: Vkus) {
            if (vkus.select) {

                binding.begItem.setBackgroundResource(R.drawable.stoke_select.toInt())
            } else {
                binding.begItem.setBackgroundResource(R.drawable.stoke_not_select)
            }

        }


    }
}





