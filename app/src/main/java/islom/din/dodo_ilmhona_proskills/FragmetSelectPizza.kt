package islom.din.dodo_ilmhona_proskills

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import islom.din.dodo_ilmhona_proskills.databinding.FragmentFragmetSelectPizzaBinding
import islom.din.dodo_ilmhona_proskills.model.ChangeData
import islom.din.dodo_ilmhona_proskills.view.PagerPizzaAdpater


class FragmetSelectPizza : Fragment() {
    private var fragmentSelectBinding: FragmentFragmetSelectPizzaBinding? = null
    var adapter = PagerPizzaAdpater()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmet_select_pizza, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = view.let { FragmentFragmetSelectPizzaBinding.bind(it) }

        binding.recyaclePager.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adapter.submitList(
            mutableListOf(
                ChangeData(1, R.drawable.pizza, "Piperni", "asdasdasdasd"),
                ChangeData(2, R.drawable.pizza, "Piperni", "asdasdasdasd"),
                ChangeData(3, R.drawable.pizza, "Piperni", "asdasdasdasd"),
                ChangeData(4, R.drawable.pizza, "Piperni", "asdasdasdasd"),
                ChangeData(5, R.drawable.pizza, "Piperni", "asdasdasdasd"),
                ChangeData(7, R.drawable.pizza, "Piperni", "asdasdasdasd"),
                ChangeData(8, R.drawable.pizza, "Piperni", "asdasdasdasd"),
                ChangeData(9, R.drawable.pizza, "Piperni", "asdasdasdasd"),
                ChangeData(10, R.drawable.pizza, "Piperni", "asdasdasdasd"),
            )
        )

        binding.recyaclePager.adapter = adapter

        binding.root.setOnClickListener {
            if (requireActivity().supportFragmentManager.findFragmentByTag("comboFragment") != null) {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.frame_layout,
                        requireActivity().supportFragmentManager.findFragmentByTag("comboFragment")!!
                    )
                    .commit()
            } else
                Toast.makeText(requireContext(), "No fragment!", Toast.LENGTH_SHORT).show()
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmetSelectPizza()
    }
}