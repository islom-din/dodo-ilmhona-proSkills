package islom.din.dodo_ilmhona_proskills.view.half

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.data.Vkus
import islom.din.dodo_ilmhona_proskills.databinding.ItemImagePagerBinding

class HalfAdapter:ListAdapter<Vkus,HalfAdapter.HalfViewHolder>(DiffUtils()){
    inner class HalfViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    val binding = ItemImagePagerBinding.bind(itemView)
        fun bindName(vkus: Vkus){
            binding.showImagePager.setImageResource(vkus.image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HalfViewHolder {
        return HalfViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_image_pager,parent,false))
    }

    override fun onBindViewHolder(holder: HalfViewHolder, position: Int) {
       holder.bindName(getItem(position))
    }
}
class DiffUtils():DiffUtil.ItemCallback<Vkus>(){
    override fun areItemsTheSame(oldItem: Vkus, newItem: Vkus): Boolean = oldItem.id==oldItem.id

    override fun areContentsTheSame(oldItem: Vkus, newItem: Vkus): Boolean = oldItem ==newItem

}