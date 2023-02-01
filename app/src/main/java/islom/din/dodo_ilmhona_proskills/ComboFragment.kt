package islom.din.dodo_ilmhona_proskills

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import islom.din.dodo_ilmhona_proskills.databinding.FragmentComboBinding
import islom.din.dodo_ilmhona_proskills.model.ChangeData
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
        super.onViewCreated(view, savedInstanceState)
        val binding = view.let { FragmentComboBinding.bind(it) }
        fragmentComboBinding = binding
        rcView = view.findViewById(R.id.recycleViewCombo)
        adapter = ChangeAdapter()

        rcView.adapter = adapter
        rcView.layoutManager = LinearLayoutManager(context)

        val list = mutableListOf(
            ChangeData(1, R.drawable.pizza, "Piperni", "asdasdasdasd"),
            ChangeData(2, R.drawable.pizza, "Piperni", "asdasdasdasd"),
            ChangeData(3, R.drawable.pizza, "Piperni", "asdasdasdasd"),
        )
        adapter.submitList(list)

        adapter.onClickItem = {
            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.frame_layout, FragmetSelectPizza.newInstance()).commit()
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = ComboFragment()
    }
}