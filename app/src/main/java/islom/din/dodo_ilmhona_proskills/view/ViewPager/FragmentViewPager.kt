package islom.din.dodo_ilmhona_proskills.view.ViewPager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import islom.din.dodo_ilmhona_proskills.databinding.ViewpagerLayoutBinding

class FragmentViewPager:Fragment() {
    private val _binding:ViewpagerLayoutBinding? =null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = view.let { ViewpagerLayoutBinding.bind(it) }
        binding.viewPagerLayout

    }
}