package islom.din.dodo_ilmhona_proskills.dbMain

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import islom.din.dodo_ilmhona_proskills.dbMain.*

@Database(
    entities = [Ingredients::class,IngredientSize::class,IngredientSizeConnection::class,
    IngredientsProductsConnection::class,Products::class],
    version = 1
)
abstract class DataBaseMain : RoomDatabase() {

    abstract fun ingredientsDao() : IngredientsDao

    abstract fun ingredientProductsConnectionDao() : IngredientsProductsConnectionDao
    
    abstract fun productsDao() : ProductsDao

    companion object {
        @Volatile
        private var INSTANCE: DataBaseMain? = null

        fun getInstance(context: Context): DataBaseMain {
            synchronized(this) {

                if (INSTANCE == null) {
                    val builder = Room.databaseBuilder(
                        context.applicationContext,
                        DataBaseMain::class.java,
                        "main_db"
                    )

                    INSTANCE = builder.build()
                    return INSTANCE!!
                }
                return INSTANCE!!
            }
        }
    }
}