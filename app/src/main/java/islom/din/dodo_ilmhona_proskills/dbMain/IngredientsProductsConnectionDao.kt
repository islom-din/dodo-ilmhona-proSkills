package islom.din.dodo_ilmhona_proskills.dbMain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface IngredientsProductsConnectionDao {
    @Insert
    suspend fun insertAll(ingredientsProductsConnection: IngredientsProductsConnection)

    @Query("SELECT * FROM ingredients_products_connection WHERE products = :productsId")
    fun getAllIngredientsByProductsId(product_id: Products) : List<IngredientsProductsConnection>
}