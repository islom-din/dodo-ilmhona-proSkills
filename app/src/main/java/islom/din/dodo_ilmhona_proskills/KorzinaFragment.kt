package islom.din.dodo_ilmhona_proskills

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.asLiveData
import islom.din.dodo_ilmhona_proskills.KHQ.roomViewModel.RoomViewModel
import islom.din.dodo_ilmhona_proskills.KHQ.roomViewModel.RoomViewModelFactory
import islom.din.dodo_ilmhona_proskills.QA.Constants
import islom.din.dodo_ilmhona_proskills.QA.adapter.InterestingAdapter
import islom.din.dodo_ilmhona_proskills.QA.data.Pizza
import islom.din.dodo_ilmhona_proskills.application.DataBaseApplication
import islom.din.dodo_ilmhona_proskills.databinding.FragmentKorzinaBinding


class KorzinaFragment : Fragment() {

    private var _binding: FragmentKorzinaBinding? = null
    private val binding get() = _binding!!

    //Room View Model
    private val roomViewModel: RoomViewModel by activityViewModels {
        RoomViewModelFactory((requireActivity().application as DataBaseApplication).database.ingredientsDao(),
            (requireActivity().application as DataBaseApplication).database.ingredientProductsConnectionDao(),
            (requireActivity().application as DataBaseApplication).database.productsDao(),
            (requireActivity().application as DataBaseApplication).database.orderDao())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentKorzinaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO recycler view not done yet. This is just for TESTING purposes
        var adapter = InterestingAdapter()

        roomViewModel.getBusket(Constants.USER_ID)

        roomViewModel.busketList.observe(viewLifecycleOwner) {

            //Temporary for creating Pizza class from Product class
            val listOfPizza = mutableListOf<Pizza>()
//            it.forEach {
//                val newPizza = Pizza(id = it.id, image = it.image, name = it.name, about = it.about, price = it.price!!,
//                    category = it.category)
//                listOfPizza.add(newPizza)
//            }
            adapter.submitList(listOfPizza)
        }
        binding.korzinaItems.adapter = adapter

        roomViewModel.getProducts.asLiveData().observe(viewLifecycleOwner) {
            Log.d("TESTING", "$it")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}