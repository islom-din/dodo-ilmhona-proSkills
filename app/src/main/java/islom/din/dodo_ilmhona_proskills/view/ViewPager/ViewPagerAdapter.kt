package islom.din.dodo_ilmhona_proskills.view.ViewPager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import islom.din.dodo_ilmhona_proskills.repository.GetPizzaList
import islom.din.dodo_ilmhona_proskills.view.Constants
import islom.din.dodo_ilmhona_proskills.view.ShowFragment

class ViewPagerAdapter(fa:FragmentViewPager):FragmentStateAdapter(fa) {
    private val list: List<Fragment>

    init {
        list = getList()
    }
    private fun getList(): List<Fragment> {
        val list = mutableListOf<Fragment>()
        val foodList = GetPizzaList().getList().filter { it.category != Constants.COMBO }
        for (i in foodList) {
            list.add(ShowFragment.newInstance(i))
        }
        return list
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }
}