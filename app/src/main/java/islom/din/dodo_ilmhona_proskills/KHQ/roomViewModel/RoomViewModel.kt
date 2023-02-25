package islom.din.dodo_ilmhona_proskills.KHQ.roomViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import islom.din.dodo_ilmhona_proskills.KHQ.dbMain.*
import islom.din.dodo_ilmhona_proskills.QA.data.Pizza
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomViewModel(private val ingredientsDao: IngredientsDao,
                    private val ingredientsProductsConnectionDao: IngredientsProductsConnectionDao,
                    private val productsDao: ProductsDao,
                    private val orderDao: OrderDao
) : ViewModel() {
    val getProducts = productsDao.getAllProducts()

    private var _busketList = MutableLiveData<List<Products>>()
    val busketList : LiveData<List<Products>> get() = _busketList

    fun insertProducts(pizza : Pizza){
        val products = Products(name = pizza.name, image = pizza.image, price = pizza.price, category = pizza.category, about = pizza.about)
        viewModelScope.launch {
            productsDao.insertAll(products)
        }
    }

    fun newOrderConnection(userId : Int,productId: Int) {
        val orderConnection = OrderConnection(userId = userId, productId = productId)
        Log.d("TESTING","${orderConnection.userId} && ${orderConnection.productId}")
        viewModelScope.launch {
            orderDao.newOrderConnection(orderConnection)
        }
    }

    fun getBusket(userId: Int){
        viewModelScope.launch(Dispatchers.IO) {
            _busketList.postValue(orderDao.getOrderedProducts(user_id = userId))
        }
    }
}


