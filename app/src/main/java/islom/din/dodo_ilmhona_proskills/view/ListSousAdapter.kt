package islom.din.dodo_ilmhona_proskills.view

import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.databinding.ItemRecyclerSousViewBinding

import islom.din.dodo_ilmhona_proskills.model.Sous

class ListSousAdapter : ListAdapter<Sous, ListSousAdapter.SousViewHolder>(MyDiffUtil()) {
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
        fun bindImage(sous: Sous) {
            binding.imageSous.setImageResource(sous.image)
            binding.seconcklik.setStrokeColorResource(R.color.black.toInt())
            binding.imageSous.setOnClickListener() {
                onClick.invoke(adapterPosition)
                sous.checked = true
                showChecked(sous)
                showHide(binding.seconcklik)
                showHide(binding.selectImage)
                showHide(binding.isoncklik)

            }
            binding.seconcklik.setOnClickListener(){
                sous.checked =false
            }

        }


        fun bindText(sous: Sous) {
            binding.sousName.text = sous.name
        }

        fun bindSena(sous: Sous) {
            binding.sena.text = sous.sena.toString()
        }

        fun showHide(view: View) {
            view.visibility = if (view.visibility == View.VISIBLE) {
                View.INVISIBLE
            } else {
                View.VISIBLE
            }
        }

        fun showChecked(sous: Sous) {
            if (sous.checked) {

                binding.seconcklik.setStrokeColorResource(R.color.orange.toInt())
            } else {
                binding.seconcklik.setStrokeColorResource(R.color.black.toInt())

            }


        }
    }
}




