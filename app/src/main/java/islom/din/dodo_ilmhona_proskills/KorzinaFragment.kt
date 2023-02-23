package islom.din.dodo_ilmhona_proskills

import android.os.Bundle
import android.provider.ContactsContract.RawContacts.Data
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import islom.din.dodo_ilmhona_proskills.KHQ.roomViewModel.RoomViewModel
import islom.din.dodo_ilmhona_proskills.KHQ.roomViewModel.RoomViewModelFactory
import islom.din.dodo_ilmhona_proskills.application.DataBaseApplication
import islom.din.dodo_ilmhona_proskills.databinding.FragmentKorzinaBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


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

        roomViewModel.getProducts.asLiveData().observe(viewLifecycleOwner) {
            Log.d("TESTING", "$it")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}