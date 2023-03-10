package islom.din.dodo_ilmhona_proskills.khq.roomViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import islom.din.dodo_ilmhona_proskills.QA.data.Pizza
import islom.din.dodo_ilmhona_proskills.khq.dbMain.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomViewModel(private val ingredientsDao: IngredientsDao,
                    private val ingredientsProductsConnectionDao: IngredientsProductsConnectionDao,
                    private val productsDao: ProductsDao,
                    private val orderDao: OrderDao
) : ViewModel() {

//    private var _orderNumber = MutableLiveData<Int>()
//    val orderNumber : LiveData<Int> get() = _orderNumber

     fun getOrderNumber(userId: Int) : Int {
        return orderDao.getOrderNumber(userId)
    }

    fun deleteOrderFromBusket(order_number: Int){
        viewModelScope.launch(Dispatchers.IO) {
            orderDao.deleteOrder(order_number)
        }
    }

    fun getOrderConnection(order_number: Int) : List<OrderConnection> {
        return orderDao.getOrderByUserId(order_number)
    }

    fun insertProducts(pizza : Pizza){
        val products = Products(name = pizza.name, image = pizza.image, price = pizza.price, category = pizza.category, about = pizza.about)
        viewModelScope.launch {
            productsDao.insertAll(products)
        }
    }

    fun updateOrderAmount(amount: Int,order_number: Int, productId: Int,) {
        viewModelScope.launch(Dispatchers.IO) {
            orderDao.updateOrderAmount(amount, order_number, productId)
        }
    }

    fun newOrderConnection(order_number : Int,productId: Int,amount : Int) {
        val orderConnection = OrderConnection(order_number = order_number, productId = productId, amount = amount)
        viewModelScope.launch {
            orderDao.newOrderConnection(orderConnection)
        }
    }

    fun getBusket(order_number: Int) : LiveData<List<Products>>? {
            return orderDao.getOrderedProducts(order_number = order_number).asLiveData()
        }

    fun getProductsSum(order_number : Int) : LiveData<Int> {
        return orderDao.getProductsSum(order_number).asLiveData()
    }

//    fun getOrderedProductsAmount() : LiveData<List<Int>>{
//        viewModelScope.launch(Dispatchers.IO) {
//            orderDao.getOrderedProductsAmount(Constants.USER_ID)
//        }
//    }

    fun newOrderHistory(order_number : Int,productId: Int,amount : Int){
            val orderHistory = OrderHistory(order_number = order_number, productId = productId, amount = amount)
            Log.d("TESTING","$orderHistory")
            orderDao.insertOrderHistory(orderHistory)
        }

    fun deleteOrder(productId: Int,order_number: Int){
        viewModelScope.launch(Dispatchers.IO) {
            orderDao.deleteOrder(order_number,productId)
        }
    }

    fun getOrderedAmountLiveData(ordered_number : Int) : LiveData<List<Int>> {
        return orderDao.getOrderedAmount(order_number = ordered_number).asLiveData()
    }

    fun newOrder(order : Order) {
        viewModelScope.launch(Dispatchers.IO) {
            orderDao.insertNewOrder(order)
        }
    }
}


