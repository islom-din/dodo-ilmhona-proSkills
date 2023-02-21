package com.example.order.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.order.GetPizzaList
import islom.din.dodo_ilmhona_proskills.databinding.FragmentProfilFragementBinding
import islom.din.dodo_ilmhona_proskills.view.profil.OrderListAdapter

class ProfilFragement : Fragment() {
  private  lateinit var binding: FragmentProfilFragementBinding
  private lateinit var adapter: OrderListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding= FragmentProfilFragementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = OrderListAdapter()
        binding.recyclerItem.layoutManager=
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerItem.adapter=adapter
        adapter.submitList(GetPizzaList().getList())
        binding.coint.setOnClickListener{
         val acion= ProfilFragementDirections.actionProfilFragement2ToDodoCoinFragment2()
            findNavController().navigate(acion)
            Toast.makeText(requireContext(), "run", Toast.LENGTH_LONG).show()
        }


    }

    companion object {

        @JvmStatic
        fun newInstance() = ProfilFragement()
    }
}