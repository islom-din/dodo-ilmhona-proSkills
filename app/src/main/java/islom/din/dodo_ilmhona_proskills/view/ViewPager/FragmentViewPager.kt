package islom.din.dodo_ilmhona_proskills.view.ViewPager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import islom.din.dodo_ilmhona_proskills.databinding.ViewpagerLayoutBinding
import kotlin.math.abs

class FragmentViewPager:Fragment() {
    private var _binding:ViewpagerLayoutBinding? =null
private val binding get() =  _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ViewpagerLayoutBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       val adapter = ViewPagerAdapter(this)
        binding.viewPagerLayout.adapter = adapter
        binding.viewPagerLayout.setPageTransformer(getTransformation())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private fun getTransformation(): CompositePageTransformer {
             val transformer = CompositePageTransformer()
             transformer.addTransformer(MarginPageTransformer(30))
             transformer.addTransformer { page, position ->
                 page.scaleY = 0.85f + (1 - abs(position)) * 0.15f

             }
             return transformer
         }
    }

}