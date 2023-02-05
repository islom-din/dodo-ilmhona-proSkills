package islom.din.dodo_ilmhona_proskills.view

import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.chip.Chip
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.data.Vkus
import islom.din.dodo_ilmhona_proskills.databinding.ChipItemBinding
import islom.din.dodo_ilmhona_proskills.databinding.DeleteIngridientItemBinding
import islom.din.dodo_ilmhona_proskills.databinding.ViewShowFragmentBinding
import islom.din.dodo_ilmhona_proskills.model.Pizza
import islom.din.dodo_ilmhona_proskills.view.half.FragmentHalfPizza
import islom.din.dodo_ilmhona_proskills.viewModel.MyViewModel


private const val ARG_PARAM1 = "param1"
private lateinit var pizza: Pizza

 class ShowFragment : Fragment() {





     private var _binding: ViewShowFragmentBinding? = null
    lateinit var recycler: RecyclerView
    lateinit var adapter: ListSousAdapter
    private val myViewModel = MyViewModel()
    var parent1: Pizza? = null
    val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            parent1 = it.getParcelable(ARG_PARAM1)
            pizza = parent1!!

        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this._binding = ViewShowFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      val binding = view.let { ViewShowFragmentBinding.bind(it) }
        binding.imageShowOder.setImageResource(pizza.image)
        binding.nameShowder.text=pizza.name
        binding.description.text= pizza.name
        binding.descriptionShowder.text=pizza.about
        binding.classic.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.frame_layout, FragmentHalfPizza.newInstance()
                ).commit()


        }

        binding.nameShowder.setOnClickListener {
            val view = setupChip()
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Убрать ингридиенты")

                .setPositiveButton("ГОТОВО") { dialog, which: Int ->
                    dialog.dismiss()
                }
                .setNegativeButton("Сбросить") { dialog, which: Int ->
                    dialog.cancel()
                }
                .setView(view.root)
                .show()
        }

//        binding.nameShowder.setOnClickListener {
//            RemoteDialogFragment().show(
//                childFragmentManager,RemoteDialogFragment.TAG)
//        }
        binding.descriptionShowder.setOnClickListener {
            getAbout()
        }
        getRecycler()
        onClickSmail()
        onClickBig()
        onClickNormal()
        onClickType()
        getSelectItem()

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newIntent() = ShowFragment()
        fun newInstance(param1: Pizza) =
            ShowFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, param1)

                }
            }

    }
     private fun setupChip() : DeleteIngridientItemBinding {
         //TODO: get ingridients from array
         // 1) Save them in liveData, this liveData will be saved in ViewModel
         val deleteIngridient: List<String> = binding.descriptionShowder.text.split(",")
         var dialogBinding = DeleteIngridientItemBinding.inflate(requireActivity().layoutInflater)
         for (name in deleteIngridient) {
             val chip = createChip(name)
             dialogBinding.chipGroup.addView(chip)
         }
         return dialogBinding
     }

     private fun createChip(ingridient: String): Chip {
         val chip = ChipItemBinding.inflate(layoutInflater).root
         chip.text = ingridient
         return chip


     }

    fun showHide(view: View) {
        view.visibility = View.INVISIBLE

    }

    fun getRecycler() {
        recycler = binding.recSous
        adapter = ListSousAdapter()
        recycler.adapter = adapter
        recycler.layoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)
        adapter.submitList(myViewModel.getList())

    }

    fun onClickSmail() {
        binding.small.setOnClickListener {
            binding.small.setBackgroundResource(R.drawable.background_select)
            binding.big.setBackgroundResource(R.drawable.back_selcted)
            binding.normal.setBackgroundResource(R.drawable.back_selcted)
            binding.classic.setBackgroundResource(R.drawable.background_select)
            binding.tonciy.setBackgroundResource(R.drawable.back_selcted)
            binding.imageShowOder.setImageResource(R.drawable.ingridient_12)
            binding.tonciy.isGone = true
            binding.classic.width = ViewGroup.LayoutParams.MATCH_PARENT


            adapter.submitList(myViewModel.getList())
        }
    }

    fun onClickBig() {
        binding.big.setOnClickListener {
            binding.small.setBackgroundResource(R.drawable.back_selcted)
            binding.big.setBackgroundResource(R.drawable.background_select)
            binding.normal.setBackgroundResource(R.drawable.back_selcted)
            binding.tonciy.setBackgroundResource(R.drawable.back_selcted)
            binding.imageShowOder.setImageResource(R.drawable.ingridient_1)
            adapter.submitList(myViewModel.getList())
            binding.tonciy.isGone = false
        }
    }

    fun onClickNormal() {
        binding.normal.setOnClickListener {
            binding.small.setBackgroundResource(R.drawable.back_selcted)
            binding.big.setBackgroundResource(R.drawable.back_selcted)
            binding.normal.setBackgroundResource(R.drawable.background_select)
            binding.tonciy.setBackgroundResource(R.drawable.back_selcted)
            binding.imageShowOder.setImageResource(R.drawable.ingridient_12)
            adapter.submitList(myViewModel.getList())
            binding.tonciy.isGone = false
        }
    }

    fun onClickType() {
        binding.tonciy.setOnClickListener {
            binding.tonciy.setBackgroundResource(R.drawable.background_select)
            binding.classic.setBackgroundResource(R.drawable.back_selcted)
            adapter.submitList(myViewModel.getList())

        }
    }

    fun getSelectItem() {
        adapter.onClick = {
            val newList = mutableListOf<Vkus>()
            val periodicList = adapter.currentList

            for (index in periodicList.indices) {
                if (index == it) {
                    val listes = periodicList[it].copy(select = true)
                    newList.add(listes)
                } else {
                    newList.add(periodicList[index])
                }
                adapter.submitList(newList)

            }
        }
    }
    fun getAbout(){

   binding.descriptionShowder.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
    }


}





