package islom.din.dodo_ilmhona_proskills.KHQ.roomViewModel

import androidx.lifecycle.ViewModel
import islom.din.dodo_ilmhona_proskills.dbMain.IngredientsDao
import islom.din.dodo_ilmhona_proskills.dbMain.IngredientsProductsConnectionDao
import islom.din.dodo_ilmhona_proskills.dbMain.ProductsDao

class RoomViewModel(private val ingredientsDao: IngredientsDao,
                    private val ingredientsProductsConnectionDao: IngredientsProductsConnectionDao,
                    private val productsDao: ProductsDao) : ViewModel() {
    val getProducts = productsDao.getAllProducts()
}

