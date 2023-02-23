package islom.din.dodo_ilmhona_proskills.KHQ.roomViewModel

import androidx.lifecycle.ViewModel
import islom.din.dodo_ilmhona_proskills.KHQ.dbMain.IngredientsDao
import islom.din.dodo_ilmhona_proskills.KHQ.dbMain.IngredientsProductsConnectionDao
import islom.din.dodo_ilmhona_proskills.KHQ.dbMain.OrderDao
import islom.din.dodo_ilmhona_proskills.KHQ.dbMain.ProductsDao

class RoomViewModel(private val ingredientsDao: IngredientsDao,
                    private val ingredientsProductsConnectionDao: IngredientsProductsConnectionDao,
                    private val productsDao: ProductsDao,
                    private val orderDao: OrderDao
) : ViewModel() {
    val getProducts = productsDao.getAllProducts()
}

