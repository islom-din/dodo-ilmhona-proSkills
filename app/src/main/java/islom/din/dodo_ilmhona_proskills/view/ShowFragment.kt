package islom.din.dodo_ilmhona_proskills.view

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StrikethroughSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.contains
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.chip.Chip
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.data.Pizza
import islom.din.dodo_ilmhona_proskills.data.Vkus
import islom.din.dodo_ilmhona_proskills.databinding.ChipItemBinding
import islom.din.dodo_ilmhona_proskills.databinding.ChipTextItemBinding
import islom.din.dodo_ilmhona_proskills.databinding.DeleteIngridientItemBinding
import islom.din.dodo_ilmhona_proskills.databinding.ViewShowFragmentBinding
import islom.din.dodo_ilmhona_proskills.model.DataViewModel


private const val ARG_PARAM1 = "param1"


class ShowFragment : Fragment() {

    private lateinit var pizza: Pizza

    //lateinit var catrgoty:Constants
    private var _binding: ViewShowFragmentBinding? = null
    lateinit var recycler: RecyclerView
    lateinit var adapter: ListSousAdapter
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
        savedInstanceState: Bundle?,
    ): View? {
        this._binding = ViewShowFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = view.let { ViewShowFragmentBinding.bind(it) }

        when (pizza.category) {
            Constants.PIZZA -> {
                binding.removeIngrelienites.setOnClickListener {
                    val view = setupChip()
                    MaterialAlertDialogBuilder(requireContext())
                        .setPositiveButton("DONE") { dialog, which ->
                            Log.d("MyERROR", "${pizza.ingridientList}")
                            for (ingrident in pizza.ingridientList!!.withIndex())
                                if (ingrident.index !in view.chipGroup.checkedChipIds)
                                    pizza.ingridientList!![ingrident.index].delete = true
                            Log.d("MyERROR", "${pizza.ingridientList}")
                            dialog.dismiss()

                        }
                        .setNeutralButton("CLEAR") { dialog, which ->

                            dialog.dismiss()
                        }
                        .setView(view.root)
                        .show()
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
                setupChipFurst()
                getRecycler()
                onClickSmail()
                onClickBig()
                onClickNormal()
                onClickType()
            }
            else -> {
                binding.apply {
                    recSous.visibility = View.INVISIBLE
                    linearLayout.visibility = View.INVISIBLE
                    removeIngrelienites.visibility = View.INVISIBLE
                    if(pizza.category == Constants.DESERTI)
                        linearLayout2.visibility = View.INVISIBLE
                }
            }
        }

        binding.imageShowOder.setImageResource(pizza.image)
        binding.nameShowder.text = pizza.name
        binding.description.text = pizza.name
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

    fun getRecycler() {
        recycler = binding.recSous
        adapter = ListSousAdapter()
        recycler.adapter = adapter
        recycler.layoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)

        adapter.sizeType = Constants.SREDNAYA
        adapter.submitList(pizza.getList())
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
            adapter.sizeType = Constants.MALENKAYA
            seleltList()

        }
    }

    fun onClickBig() {
        binding.big.setOnClickListener {
            binding.small.setBackgroundResource(R.drawable.back_selcted)
            binding.big.setBackgroundResource(R.drawable.background_select)
            binding.normal.setBackgroundResource(R.drawable.back_selcted)
            binding.tonciy.setBackgroundResource(R.drawable.back_selcted)
            binding.imageShowOder.setImageResource(R.drawable.ingridient_1)

            adapter.sizeType = Constants.BOLSHAYA
            adapter.submitList(pizza.getList())
            binding.tonciy.isGone = false
            seleltList()
        }
    }

    fun onClickNormal() {
        binding.normal.setOnClickListener {
            binding.small.setBackgroundResource(R.drawable.back_selcted)
            binding.big.setBackgroundResource(R.drawable.back_selcted)
            binding.normal.setBackgroundResource(R.drawable.background_select)
            binding.tonciy.setBackgroundResource(R.drawable.back_selcted)
            binding.imageShowOder.setImageResource(R.drawable.ingridient_12)

            adapter.sizeType = Constants.SREDNAYA
            adapter.submitList(pizza.getList())
            binding.tonciy.isGone = false
            seleltList()
        }
    }

    fun onClickType() {
        binding.tonciy.setOnClickListener {
            binding.tonciy.setBackgroundResource(R.drawable.background_select)
            binding.classic.setBackgroundResource(R.drawable.back_selcted)
            adapter.submitList(pizza.getList())
        }
    }

    fun onClickInfo() {
        binding.info.setOnClickListener {
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


    private fun setupChip(): DeleteIngridientItemBinding {
        val view = DeleteIngridientItemBinding.inflate(layoutInflater)
        for (item in pizza.ingridientList!!.withIndex()) {
            val chip = createChip(item.value.name)
            chip.id = item.index
            chip.setOnClickListener() {

            }
            if (view.chipGroup.contains(chip))
                view.chipGroup.removeAllViews()
            view.chipGroup.addView(chip)
            chip.isChecked = !item.value.delete
            pizza.ingridientList!!.map {
                if (!it.delete) {
                    chip.isGone
                }
            }

            Log.d("MyERROR", "${chip.isChecked}")
        }

        view.chipGroup.setOnCheckedStateChangeListener { _, checkedIds ->
            val size = binding.descriptionShowder.size
            binding.descriptionShowder.removeAllViews()
            for (i in 0 until size) {
                val chip = createChiptext(pizza.ingridientList!![i].name)
                chip.id = i

                if (i !in checkedIds) {
                    val spannable = SpannableString(chip.text)
                    spannable.setSpan(
                        StrikethroughSpan(),
                        0,
                        chip.text.length,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                    chip.text = spannable
                }

                binding.descriptionShowder.addView(chip)
            }
        }
        return view
    }

    private fun setupChipFurst() {
        for (item in pizza.ingridientList!!.withIndex()) {
            val chip = createChiptext(item.value.name)
            chip.id = item.index
            binding.descriptionShowder.addView(chip)
        }
    }

    private fun createChiptext(category: String): TextView {
        val textView = ChipTextItemBinding.inflate(layoutInflater).root
        textView.text = category
        return textView
    }

    private fun createChip(category: String): Chip {
        val chip = ChipItemBinding.inflate(layoutInflater).root
        chip.text = category
        return chip
    }

    fun seleltList() {

        var newList = mutableListOf<Vkus>()
        for (item in pizza.getList()) {
            newList.add(item.copy(select = false))
        }

        adapter.submitList(newList)
    }
}