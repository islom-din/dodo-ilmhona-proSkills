package islom.din.dodo_ilmhona_proskills.KHQ.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import islom.din.dodo_ilmhona_proskills.KHQ.adapter.OrderAdapter
import islom.din.dodo_ilmhona_proskills.KHQ.dbMain.OrderConnectionServer
import islom.din.dodo_ilmhona_proskills.KHQ.roomViewModel.RoomViewModel
import islom.din.dodo_ilmhona_proskills.KHQ.roomViewModel.RoomViewModelFactory
import islom.din.dodo_ilmhona_proskills.QA.Constants
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.application.DataBaseApplication
import islom.din.dodo_ilmhona_proskills.databinding.FragmentKorzinaBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class KorzinaFragment : Fragment() {

    private var _binding: FragmentKorzinaBinding? = null
    private val binding get() = _binding!!

    private var adapter = OrderAdapter()

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

        onOrderClicked()
        navigateToHomeFragment()
        observe()
        orderedBusketObserve()

        adapter.updateAmount = { productId,amount ->
            roomViewModel.updateOrderAmount(amount,Constants.USER_ID,productId)
        }


        binding.rvKorzinaItems.adapter = adapter
    }
    private fun orderedBusketObserve() {
        val busketList = roomViewModel.getBusket(Constants.USER_ID)
        busketList?.observe(viewLifecycleOwner) { list ->
            if (list.isEmpty()){
                binding.rvKorzinaItems.visibility = View.GONE
                binding.korzinaCountItems.visibility = View.GONE
                binding.emptyContainer.visibility = View.VISIBLE
                binding.btnCreateOrder.visibility = View.GONE
            }else {
                binding.rvKorzinaItems.visibility = View.VISIBLE
                binding.korzinaCountItems.visibility = View.VISIBLE
                binding.emptyContainer.visibility = View.GONE
                binding.btnCreateOrder.visibility = View.VISIBLE
            }
            adapter.submitList(list)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun observe() {
        roomViewModel.getProductsSum().observe(viewLifecycleOwner) {
            binding.txtKorzina.text = "${adapter.currentList.size} товара на $it TJS"
        }
    }

    private fun navigateToHomeFragment(){
        binding.korzinaEmptyBtn.setOnClickListener {
            findNavController().navigate(R.id.action_korzinaFragment_to_navigation_home)
        }
    }

    private fun onOrderClicked() {
        binding.btnCreateOrder.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                val newOrderServerList = mutableListOf<OrderConnectionServer>()
                roomViewModel.getOrderByUserId(Constants.USER_ID).forEach {
                    newOrderServerList.add(OrderConnectionServer(userId = it.userId, productId = it.productId, amount = it.amount))
                }
                roomViewModel.newOrderServer(newOrderServerList)
                roomViewModel.deleteOrderByUserId(Constants.USER_ID)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}