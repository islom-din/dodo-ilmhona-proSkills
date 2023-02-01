package islom.din.dodo_ilmhona_proskills.fragment.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.chip.Chip
import islom.din.dodo_ilmhona_proskills.Constants
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.adapter.PizzaAdapter
import islom.din.dodo_ilmhona_proskills.databinding.ChipItemBinding
import islom.din.dodo_ilmhona_proskills.databinding.FragmentHomeBinding
import islom.din.dodo_ilmhona_proskills.viewmodel.HomeViewModel
import kotlinx.coroutines.CoroutineScope

class HomeFragment : Fragment() {
    //binding
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    //View Model
    private val viewModel: HomeViewModel by viewModels()

    val adapterForPizza = PizzaAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Creating all categories programmatically
        setupChip()
        scrollingOnCategoryClicked()
        chooseCity()
        scrollingChangeListener()
        settingPizzaRecyclerView()


        // Not used, but alternatively method for Category RecyclerView
//        settingCategoryRecyclerView()

    }

    private fun scrollingChangeListener() {
        binding.pizzaRv.setOnScrollChangeListener { v, _, _, _, _ ->
            val pos =
                (binding.pizzaRv.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

            val currentList = adapterForPizza.currentList

            if (currentList[pos].category == Constants.PIZZA) {
                val chipsIndex = getIndexOfThisChip(currentList[pos].category)
                val chip = binding.chipCategoryGroup[chipsIndex]
                binding.chipCategoryGroup.check(chip.id)
            } else {
                if (currentList[pos].category != currentList[pos - 1].category ||
                    currentList[pos].category != currentList[pos + 1].category
                ) {
                    val chipsIndex =
                        getIndexOfThisChip(adapterForPizza.currentList[pos].category)
                    val chip = binding.chipCategoryGroup[chipsIndex]
                    binding.chipCategoryGroup.check(chip.id)
                }
            }
        }
    }

    private fun scrollingOnCategoryClicked() {
        binding.chipCategoryGroup.setOnCheckedStateChangeListener { group, checkedIds ->
            var checkedId = checkedIds.first()
            var checkedCategoryButton = requireActivity().findViewById<Chip>(checkedId)
            checkedCategoryButton.setOnClickListener {
                binding.pizzaRv.smoothScrollToPosition(adapterForPizza.currentList.indexOfFirst {
                    it.category == checkedCategoryButton.text
                } + 1)
                //Expands App Bar layout
                if (checkedCategoryButton.text == Constants.PIZZA)
                    binding.mainAppBar.setExpanded(true)
                else binding.mainAppBar.setExpanded(false)

                scrollingChangeListener()
            }
        }
    }

    private fun chooseCity() {
        val naDostavkuButton = binding.naDostavku
        val vZaleButton = binding.vZale

        //For default
        naDostavkuButton.setBackgroundResource(R.drawable.shape_chip_white)

        //What should happen if I click "V zale" button
        vZaleButton.setOnClickListener {
            it.setBackgroundResource(R.drawable.shape_chip_white)
            naDostavkuButton.setBackgroundResource(R.drawable.shape_chip_grey)
        }

        //What should happen if I click "Dostavka" button
        naDostavkuButton.setOnClickListener {
            it.setBackgroundResource(R.drawable.shape_chip_white)
            vZaleButton.setBackgroundResource(R.drawable.shape_chip_grey)
        }

    }

    private fun settingPizzaRecyclerView() {
        // Pizza recycler view initialising and setting adapter and list for it
        adapterForPizza.submitList(viewModel.pizzaList)
        binding.pizzaRv.adapter = adapterForPizza
    }

    private fun getIndexOfThisChip(category: String): Int {
        for (categoriesIndex in viewModel.categoryList.indices)
            if (category == viewModel.categoryList[categoriesIndex])
                return categoriesIndex
        return 0
    }

    private fun setupChip() {
        for (name in viewModel.categoryList) {
            val chip = createChip(name)
            binding.chipCategoryGroup.addView(chip)
            if (name == Constants.PIZZA)
                binding.chipCategoryGroup.check(chip.id)
        }
    }

    private fun createChip(category: String): Chip {
        val chip = ChipItemBinding.inflate(layoutInflater).root
        chip.text = category
        return chip
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


//    private fun settingCategoryRecyclerView() {
//        //  Category recyclerview initialising and setting adapter for it
//        val adapterForCategory = CategoryAdapter()
//        adapterForCategory.submitList(viewModel.categoryList)
//        adapterForCategory.onClickedSelectedItem = {
//            //For changing the selected Item
//            var newList = mutableListOf<Category>()
//
//            //Getting new List from previous
//            for (item in adapterForCategory.currentList.indices) {
//                if (item == it) {
//                    val newStateForCategory =
//                        adapterForCategory.currentList[item].copy(isChecked = true)
//                    newList.add(newStateForCategory)
//                } else {
//                    newList.add(viewModel.categoryList[item])
//                }
//            }
//            adapterForCategory.submitList(newList)
//        }
////        binding.categoryRv.adapter = adapterForCategory
//    }