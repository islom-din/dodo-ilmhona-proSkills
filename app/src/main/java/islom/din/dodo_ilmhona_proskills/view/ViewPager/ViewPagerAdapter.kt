package islom.din.dodo_ilmhona_proskills.view.ViewPager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import islom.din.dodo_ilmhona_proskills.data.Pizza
import islom.din.dodo_ilmhona_proskills.repository.GetPizzaList
import islom.din.dodo_ilmhona_proskills.viewModel.MyViewModel

class ViewPagerAdapter(fa:FragmentViewPager):FragmentStateAdapter(fa) {
    private var myViewModel =MyViewModel()

    fun getList(): List<Fragment> {
        val list = mutableListOf<Fragment>()
        for (i in GetPizzaList().getList()) {
            list.add(ExampleFragment.newInstance(i))
        }
        return list
    }

    override fun getItemCount(): Int {
        return getList().size

    }

    override fun createFragment(position: Int): Fragment {
        return getList()[position]
    }
}