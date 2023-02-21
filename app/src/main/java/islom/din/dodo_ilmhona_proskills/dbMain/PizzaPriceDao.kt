package islom.din.dodo_ilmhona_proskills.dbMain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PizzaPriceDao {
    @Insert
    suspend fun insertAll(vararg pizzaPrices: PizzaPrices)

    @Query("SELECT * FROM pizza_prices WHERE pizza_id = :pizza_id")
    fun getPizzaPricesById(pizza_id : Int)
}