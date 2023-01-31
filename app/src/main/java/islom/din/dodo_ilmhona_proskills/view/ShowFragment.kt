package islom.din.dodo_ilmhona_proskills.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.databinding.ViewShowFragmentBinding
import islom.din.dodo_ilmhona_proskills.model.Sous
import islom.din.dodo_ilmhona_proskills.viewModel.MyViewModel

class ShowFragment : Fragment() {

    lateinit var list: MutableList<Sous>

    private var fragmentFirstBinding: ViewShowFragmentBinding? = null
    lateinit var recyclerView: RecyclerView
    lateinit var listSousAdapter: ListSousAdapter
    private val myViewModel = MyViewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.view_show_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = view.let { ViewShowFragmentBinding.bind(it) }



        fragmentFirstBinding = binding
        recyclerView = binding.recSous
        listSousAdapter = ListSousAdapter()
        recyclerView.adapter = listSousAdapter
        recyclerView.layoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)
        listSousAdapter.submitList(myViewModel.getListCous1())



            binding.small.setOnClickListener {
                binding.small.setBackgroundResource(R.drawable.background_select)
                binding.big.setBackgroundResource(R.drawable.back_selcted)
                binding.normal.setBackgroundResource(R.drawable.back_selcted)
                //showHide(binding.tonciy)
                binding.tonciy.isGone = true
                binding.classic.width = ViewGroup.LayoutParams.MATCH_PARENT


                listSousAdapter.submitList(myViewModel.getListCous())


            }
            binding.big.setOnClickListener {
                binding.small.setBackgroundResource(R.drawable.back_selcted)
                binding.big.setBackgroundResource(R.drawable.background_select)
                binding.normal.setBackgroundResource(R.drawable.back_selcted)
                listSousAdapter.submitList(myViewModel.getListCous1())
                binding.tonciy.isGone = false
            }

            binding.normal.setOnClickListener {
                binding.small.setBackgroundResource(R.drawable.back_selcted)
                binding.big.setBackgroundResource(R.drawable.back_selcted)
                binding.normal.setBackgroundResource(R.drawable.background_select)
                listSousAdapter.submitList(myViewModel.getListCous2())
                binding.tonciy.isGone = false
            }
        listSousAdapter.onClick = {
            val newList = mutableListOf<Sous>()
            val periodicList = listSousAdapter.currentList

            for (index in periodicList.indices) {
                if (index == it) {
                    val listes = periodicList[it].copy(checked = true)
                    newList.add(listes)
                } else {
                    newList.add(periodicList[index])
                }
                listSousAdapter.submitList(newList)

            }









        }

    }

    companion object {
        fun newIntent() = ShowFragment()
    }

    fun showHide(view: View) {
        view.visibility = View.INVISIBLE

    }
}






