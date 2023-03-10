package islom.din.dodo_ilmhona_proskills.khq.fragments

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
import islom.din.dodo_ilmhona_proskills.QA.Constants
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.application.DataBaseApplication
import islom.din.dodo_ilmhona_proskills.databinding.FragmentKorzinaBinding
import islom.din.dodo_ilmhona_proskills.khq.adapter.OrderAdapter
import islom.din.dodo_ilmhona_proskills.khq.dbMain.Order
import islom.din.dodo_ilmhona_proskills.khq.roomViewModel.RoomViewModel
import islom.din.dodo_ilmhona_proskills.khq.roomViewModel.RoomViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class KorzinaFragment() : Fragment() {

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

        navigateToHomeFragment()

        lifecycleScope.launch(Dispatchers.IO) {
            val orderNumber = roomViewModel.getOrderNumber(Constants.USER_ID)
            withContext(Dispatchers.Main) {
                roomViewModel.getOrderedAmountLiveData(orderNumber).observe(viewLifecycleOwner) {
                    adapter.list = it
                    onOrderClicked(orderNumber)
                    observe(orderNumber)
                    orderedBusketObserve(orderNumber)
                }
                adapter.deleteProduct = { productId ->
                    roomViewModel.deleteOrder(productId, orderNumber)
                }

                adapter.updateAmount = { productId, amount ->
                    roomViewModel.updateOrderAmount(amount, orderNumber, productId)
                }

                binding.rvKorzinaItems.adapter = adapter
            }
        }
    }
    private fun orderedBusketObserve(orderNumber : Int) {
        val busketList = roomViewModel.getBusket(orderNumber)
        busketList?.observe(viewLifecycleOwner) { list ->
            if (list.isEmpty()){
                binding.rvKorzinaItems.visibility = View.GONE
                binding.emptyContainer.visibility = View.VISIBLE
                binding.btnCreateOrder.visibility = View.GONE
            }else {
                binding.rvKorzinaItems.visibility = View.VISIBLE
                binding.emptyContainer.visibility = View.GONE
                binding.btnCreateOrder.visibility = View.VISIBLE
            }
            Log.d("TESTING","${list}")
            adapter.submitList(list)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun observe(orderNumber : Int) {
        roomViewModel.getProductsSum(orderNumber).observe(viewLifecycleOwner) {
            binding.btnCreateOrder.text = "Оформить за $it TJS"
        }
    }

    private fun navigateToHomeFragment(){
        binding.korzinaEmptyBtn.setOnClickListener {
            findNavController().navigate(R.id.action_korzinaFragment_to_navigation_home)
        }
    }

    private fun onOrderClicked(orderNumber : Int) {
        binding.btnCreateOrder.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                roomViewModel.getOrderConnection(orderNumber).forEach {
                    roomViewModel.newOrderHistory(it.order_number,it.productId,it.amount)
                }
                roomViewModel.deleteOrderFromBusket(orderNumber)
                val order = Order(userId = Constants.USER_ID)
                roomViewModel.newOrder(order)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}