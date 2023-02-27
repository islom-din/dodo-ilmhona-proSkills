package islom.din.dodo_ilmhona_proskills.khq.dbMain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductsDao {
    @Insert
    suspend fun insertAll(vararg product: Products)

    @Update
    suspend fun update(product: Products)

    @Query("SELECT * FROM products")
    fun getAllProducts() : Flow<List<Products>>

}