package islom.din.dodo_ilmhona_proskills.KHQ.roomViewModel

import android.util.Log
import androidx.lifecycle.*
import islom.din.dodo_ilmhona_proskills.KHQ.dbMain.*
import islom.din.dodo_ilmhona_proskills.QA.Constants
import islom.din.dodo_ilmhona_proskills.QA.data.Pizza
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomViewModel(private val ingredientsDao: IngredientsDao,
                    private val ingredientsProductsConnectionDao: IngredientsProductsConnectionDao,
                    private val productsDao: ProductsDao,
                    private val orderDao: OrderDao
) : ViewModel() {

     var totalPrice = MutableLiveData<Int>(0)

    fun deleteOrderByUserId(userId: Int){
        viewModelScope.launch(Dispatchers.IO) {
            orderDao.deleteOrder(userId)
        }
    }

    fun getOrderByUserId(userId: Int) : List<OrderConnection> {
        return orderDao.getOrderByUserId(userId)
    }

//    fun insertProducts(pizza : Pizza){
//        val products = Products(name = pizza.name, image = pizza.image, price = pizza.price, category = pizza.category, about = pizza.about)
//        viewModelScope.launch {
//            productsDao.insertAll(products)
//        }
//    }

    fun updateOrderAmount(amount: Int,user_id: Int, productId: Int,) {
        viewModelScope.launch(Dispatchers.IO) {
            orderDao.updateOrderAmount(amount, user_id, productId)
        }
    }

    fun newOrderConnection(userId : Int,productId: Int,amount : Int) {
        val orderConnection = OrderConnection(userId = userId, productId = productId, amount = amount)
        viewModelScope.launch {
            orderDao.newOrderConnection(orderConnection)
        }
    }

    fun getBusket(userId: Int) : LiveData<List<Products>>? {
            return orderDao.getOrderedProducts(user_id = userId).asLiveData()
        }

    fun getProductsSum() : LiveData<Int> {
        return orderDao.getProductsSum(Constants.USER_ID).asLiveData()
    }

//    fun getOrderedProductsAmount() : LiveData<List<Int>>{
//        viewModelScope.launch(Dispatchers.IO) {
//            orderDao.getOrderedProductsAmount(Constants.USER_ID)
//        }
//    }

    fun newOrderServer(orderConnectionServerList: List<OrderConnectionServer>){
        viewModelScope.launch(Dispatchers.IO) {
            orderDao.insertOrderServer(orderConnectionServerList)
        }
    }
}


