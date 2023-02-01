package islom.din.dodo_ilmhona_proskills.shodmon.khushbakht.viewmodel

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import islom.din.dodo_ilmhona_proskills.behruz.StoryItemFragment

class VpAdapter(private val fragments: List<Fragment>, fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 7

    override fun createFragment(position: Int): Fragment {
        return StoryItemFragment()
    }
}