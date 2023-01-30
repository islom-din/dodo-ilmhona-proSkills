package islom.din.dodo_ilmhona_proskills.fragment.screens

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.chip.Chip
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.adapter.CategoryAdapter
import islom.din.dodo_ilmhona_proskills.adapter.PizzaAdapter
import islom.din.dodo_ilmhona_proskills.data.Category
import islom.din.dodo_ilmhona_proskills.databinding.FragmentHomeBinding
import islom.din.dodo_ilmhona_proskills.viewmodel.HomeViewModel

class HomeFragment : Fragment() {
    //binding
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    //View Model
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var naDostavkuButton = binding.naDostavku
        var vZaleButton = binding.vZale

        naDostavkuButton.setBackgroundResource(R.drawable.shape_chip_white)

        vZaleButton.setOnClickListener {
            it.setBackgroundResource(R.drawable.shape_chip_white)
            naDostavkuButton.setBackgroundResource(R.drawable.shape_chip_grey)

        }
        naDostavkuButton.setOnClickListener {
            it.setBackgroundResource(R.drawable.shape_chip_white)
            vZaleButton.setBackgroundResource(R.drawable.shape_chip_grey)
        }

        //  Category recyclerview initialising and setting adapter for it
        val adapterForCategory = CategoryAdapter()
        adapterForCategory.submitList(viewModel.categoryList)
        adapterForCategory.onClickedSelectedItem = {
            //For changing the selected Item
            var newList = mutableListOf<Category>()

            //Getting new List from previous
            for (item in adapterForCategory.currentList.indices) {
                if (item == it) {
                    val newStateForCategory =
                        adapterForCategory.currentList[item].copy(isChecked = true)
                    newList.add(newStateForCategory)
                } else {
                    newList.add(viewModel.categoryList[item])
                }
            }
            adapterForCategory.submitList(newList)
        }
        binding.categoryRv.adapter = adapterForCategory

        // Pizza recycler view initialising and setting adapter and list for it
        val adapterForPizza = PizzaAdapter()
        adapterForPizza.submitList(viewModel.pizzaList)
        binding.pizzaRv.adapter = adapterForPizza
        binding.pizzaRv.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}