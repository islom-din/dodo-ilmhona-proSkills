package islom.din.dodo_ilmhona_proskills.view.half

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import islom.din.dodo_ilmhona_proskills.databinding.FragmentHalfPizzaBinding
import islom.din.dodo_ilmhona_proskills.viewModel.MyViewModel
import kotlin.math.abs


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



class FragmentHalfPizza : Fragment() {
    // TODO: Rename and change types of parameters

    lateinit var viewPager: ViewPager2
    lateinit var adapter:HalfAdapter
    private val myViewModel = MyViewModel()
    private var param1: String? = null
    private var param2: String? = null
  private var _binding:FragmentHalfPizzaBinding? = null
   private val binding get()=_binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHalfPizzaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       viewPager=binding.halfPager1
        adapter = HalfAdapter()
       viewPager.adapter=adapter
        viewPager.setPageTransformer(getTransformation())
        adapter.submitList(myViewModel.getList())
       val viewPager2=binding.halfPager2
        adapter = HalfAdapter()
       viewPager2.adapter=adapter
        viewPager2.setPageTransformer(getTransformation())
        adapter.submitList(myViewModel.getList())
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            FragmentHalfPizza()
        private fun getTransformation(): CompositePageTransformer {
            val transformer = CompositePageTransformer()
            transformer.addTransformer(MarginPageTransformer(30))
            transformer.addTransformer { page, position ->
                page.scaleY = 0.85f + (1 - abs(position)) * 0.15f

            }
            return transformer
        }
    }
}