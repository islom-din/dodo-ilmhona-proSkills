package islom.din.dodo_ilmhona_proskills.view.ViewPager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.data.Pizza
import islom.din.dodo_ilmhona_proskills.databinding.ViewShowFragmentBinding
import islom.din.dodo_ilmhona_proskills.databinding.ViewpagerLayoutBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private lateinit var pizza: Pizza

class ExampleFragment : Fragment() {
    private var _binding : ViewShowFragmentBinding? = null
    private val binding get() = _binding!!

    private var param1: Pizza? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getParcelable<Pizza>(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = ViewShowFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageShowOder.setImageResource(pizza.image)
        binding.nameShowder.text=pizza.name
        binding.description.text=pizza.name
        binding.descriptionShowder.text=pizza.about

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance(param1: Pizza) =
            ExampleFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, param1)

                }
            }
    }
}