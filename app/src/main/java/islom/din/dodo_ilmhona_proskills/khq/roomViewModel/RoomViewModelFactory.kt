package islom.din.dodo_ilmhona_proskills.khq.roomViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import islom.din.dodo_ilmhona_proskills.khq.dbMain.IngredientsDao
import islom.din.dodo_ilmhona_proskills.khq.dbMain.IngredientsProductsConnectionDao
import islom.din.dodo_ilmhona_proskills.khq.dbMain.OrderDao
import islom.din.dodo_ilmhona_proskills.khq.dbMain.ProductsDao

class RoomViewModelFactory(private val ingredientsDao: IngredientsDao,
                           private val ingredientsProductsConnectionDao: IngredientsProductsConnectionDao,
                           private val productsDao: ProductsDao,
                           private val orderDao: OrderDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RoomViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return RoomViewModel(ingredientsDao, ingredientsProductsConnectionDao,productsDao,orderDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}