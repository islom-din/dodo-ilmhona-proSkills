package islom.din.dodo_ilmhona_proskills.view.ViewPager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import islom.din.dodo_ilmhona_proskills.databinding.ViewpagerLayoutBinding

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
        val binding = view.let { ViewpagerLayoutBinding.bind(it) }
       val adapter = ViewPagerAdapter(this)
        binding.viewPagerLayout

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}