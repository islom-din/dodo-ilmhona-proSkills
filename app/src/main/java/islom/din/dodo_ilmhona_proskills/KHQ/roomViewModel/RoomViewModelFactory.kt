package islom.din.dodo_ilmhona_proskills.KHQ.roomViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import islom.din.dodo_ilmhona_proskills.dbMain.IngredientsDao
import islom.din.dodo_ilmhona_proskills.dbMain.IngredientsProductsConnectionDao
import islom.din.dodo_ilmhona_proskills.dbMain.ProductsDao

class RoomViewModelFactory(private val ingredientsDao: IngredientsDao,
                           private val ingredientsProductsConnectionDao: IngredientsProductsConnectionDao,
                           private val productsDao: ProductsDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RoomViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return RoomViewModel(ingredientsDao, ingredientsProductsConnectionDao,productsDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}