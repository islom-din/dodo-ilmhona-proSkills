package islom.din.dodo_ilmhona_proskills.QA.fragment.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.chip.Chip
import islom.din.dodo_ilmhona_proskills.KHQ.roomViewModel.RoomViewModel
import islom.din.dodo_ilmhona_proskills.KHQ.roomViewModel.RoomViewModelFactory
import islom.din.dodo_ilmhona_proskills.QA.Constants
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.QA.adapter.InterestingAdapter
import islom.din.dodo_ilmhona_proskills.QA.adapter.PizzaAdapter
import islom.din.dodo_ilmhona_proskills.databinding.ChipItemBinding
import islom.din.dodo_ilmhona_proskills.databinding.FragmentHomeBinding
import islom.din.dodo_ilmhona_proskills.QA.viewmodel.HomeViewModel
import islom.din.dodo_ilmhona_proskills.application.DataBaseApplication

class HomeFragment : Fragment() {
    //binding
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    //View Model
    private val viewModel: HomeViewModel by activityViewModels()

    private val args : HomeFragmentArgs by navArgs()

    private lateinit var adapterForPizza: PizzaAdapter

    //Room View Model
    private val roomViewModel: RoomViewModel by activityViewModels {
        RoomViewModelFactory((requireActivity().application as DataBaseApplication).database.ingredientsDao(),
            (requireActivity().application as DataBaseApplication).database.ingredientProductsConnectionDao(),
            (requireActivity().application as DataBaseApplication).database.productsDao(),
            (requireActivity().application as DataBaseApplication).database.orderDao())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Making Bottom Nav View Visible
        var bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        if (!viewModel.hideBottomNavView)
            bottomNavigationView.visibility = View.VISIBLE

        adapterForPizza = PizzaAdapter()

        setupChip()
        scrollingOnCategoryClicked()
        chooseOrderType()
        scrollingChangeListener()
        settingPizzaRecyclerView()
        setupInterestingRecyclerView()



    }

    private fun setupInterestingRecyclerView() {
        val adapter = InterestingAdapter()
        adapter.submitList(viewModel.interestingList())
        binding.interestingRV.adapter = adapter
    }

//    private fun navigateToShowFragment(pizza: Pizza) {
//        val directions = HomeFragmentDirections.navigateToShowFragment(pizza)
//        findNavController().navigate(directions)
//    }

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

    private fun chooseOrderType() {
        viewModel.orderStreet.observe(requireActivity()) {
            if (viewModel.orderStreet.value == Constants.DOSTAVKA) {
                binding.naDostavku.setBackgroundResource(R.drawable.shape_chip_white)
                binding.vZale.setBackgroundResource(R.drawable.shape_chip_grey)
            }else if (viewModel.orderStreet.value == Constants.ZAL){
                binding.vZale.setBackgroundResource(R.drawable.shape_chip_white)
                binding.naDostavku.setBackgroundResource(R.drawable.shape_chip_grey)
            }
        }

            //What should happen if I click "V zale" button
        binding.vZale.setOnClickListener {
                viewModel.changeOrderType(Constants.ZAL)
            }

            //What should happen if I click "Dostavka" button
        binding.naDostavku.setOnClickListener {
                    viewModel.changeOrderType(Constants.DOSTAVKA)
            }
        }

    private fun settingPizzaRecyclerView() {
        // Pizza recycler view initialising and setting adapter and list for it
        adapterForPizza.submitList(viewModel.pizzaList)

//        Adding Pizzas to DB on price clicking
//        adapterForPizza.order = { orderedPizza ->
//            roomViewModel.insertProducts(orderedPizza)
//            Toast.makeText(requireContext(),"Added to db",Toast.LENGTH_SHORT).show()
//        }
        adapterForPizza.order = {
            roomViewModel.newOrderConnection(Constants.USER_ID,it.id,1)
            Toast.makeText(requireContext(),"Added to busket",Toast.LENGTH_SHORT).show()
        }
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