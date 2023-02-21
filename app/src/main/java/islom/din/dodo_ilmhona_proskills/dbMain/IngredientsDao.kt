package islom.din.dodo_ilmhona_proskills.dbMain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import islom.din.dodo_ilmhona_proskills.QA.data.Ingridients

@Dao
interface IngredientsDao {
    @Insert
    suspend fun insertAll(vararg ingridients: Ingridients)

    @Query("SELECT * FROM ingredients")
    suspend fun getAllIngredients() : List<Ingridients>
}