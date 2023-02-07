package islom.din.dodo_ilmhona_proskills

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import islom.din.dodo_ilmhona_proskills.databinding.FragmentComboBinding
import islom.din.dodo_ilmhona_proskills.model.DataViewModel
import islom.din.dodo_ilmhona_proskills.model.Pizza
import islom.din.dodo_ilmhona_proskills.view.ChangeAdapter

class ComboFragment : Fragment() {
    lateinit var adapter: ChangeAdapter
    lateinit var rcView: RecyclerView
    private var fragmentComboBinding: FragmentComboBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_combo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = view.let { FragmentComboBinding.bind(it) }
        fragmentComboBinding = binding
        rcView = view.findViewById(R.id.recycleViewCombo)
        adapter = ChangeAdapter()
        rcView.adapter = adapter
        rcView.layoutManager = LinearLayoutManager(context)

        val viewModel = ViewModelProvider(requireActivity())[DataViewModel::class.java]


        viewModel.list.forEach {
            binding.descriptionComboFragment.text = viewModel.combo.about
            binding.nameCombo.text = viewModel.combo.name
        }

        adapter.onClickItem = { pizza, pos ->
            viewModel.choosePizzaPosition = pos
            val action = ComboFragmentDirections.actionComboFragmentToFragmetSelectPizza(pizza)
            (requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment)
                .navController.navigate(action)
        }

        viewModel.pizza.observe(viewLifecycleOwner) { listOfPizza ->
            adapter.submitList(listOfPizza)
        }
    }

    override fun onDestroyView() {
        fragmentComboBinding = null
        super.onDestroyView()
    }
}