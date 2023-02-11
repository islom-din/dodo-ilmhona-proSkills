package islom.din.dodo_ilmhona_proskills.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PizzaDao {

    @Query("SELECT * FROM pizza")
    fun getAllPizza(): List<MPizza>

    @Query("SELECT * FROM pizza WHERE id = :id")
    fun getPizzaById(id: Int): MPizza

    @Insert
    fun insertPizza(pizza: MPizza)

    @Delete
    fun deletePizza(pizza: MPizza)
}