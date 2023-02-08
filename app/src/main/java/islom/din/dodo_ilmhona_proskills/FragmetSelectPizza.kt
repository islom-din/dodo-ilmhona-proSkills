package islom.din.dodo_ilmhona_proskills

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import islom.din.dodo_ilmhona_proskills.databinding.FragmentFragmetSelectPizzaBinding
import islom.din.dodo_ilmhona_proskills.model.Constants
import islom.din.dodo_ilmhona_proskills.model.DataViewModel
import islom.din.dodo_ilmhona_proskills.model.Pizza
import islom.din.dodo_ilmhona_proskills.view.MyViewModel
import islom.din.dodo_ilmhona_proskills.view.PagerPizzaAdpater


class FragmetSelectPizza : Fragment() {
    var adapter = PagerPizzaAdpater()

    //FragmentSelectPizzaArgs
    private val args: FragmetSelectPizzaArgs by navArgs()

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

        val viewModel = ViewModelProvider(requireActivity())[DataViewModel::class.java]
       binding.recyaclePager.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.recyaclePager.adapter = adapter



      adapter.onSelectItem = {
            viewModel.pizzaChanged(it)
            (requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment)
                .navController.navigateUp()
        }

        var list = mutableListOf<Pizza>()

        val category = args.pizza

        when(category.category) {
            Constants.PIZZA ->
                list = MyViewModel().Pizza()
            Constants.NAPITKI ->
                list = MyViewModel().Napitki()
            Constants.SOUSI ->
                list = MyViewModel().Sous()
            Constants.ZAKUSKI ->
                list = MyViewModel().Zakuski()
            Constants.DESERTI ->
                list = MyViewModel().Desert()
        }

        adapter.submitList(list)

        binding.root.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}