package islom.din.dodo_ilmhona_proskills.khq.dbMain

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Ingredients::class, IngredientSize::class, IngredientSizeConnection::class,
    IngredientsProductsConnection::class, Products::class,Order::class,OrderConnection::class,OrderHistory::class],
    version = 1
)
abstract class DataBaseMain : RoomDatabase() {

    abstract fun ingredientsDao() : IngredientsDao

    abstract fun ingredientProductsConnectionDao() : IngredientsProductsConnectionDao
    
    abstract fun productsDao() : ProductsDao

    abstract fun orderDao() : OrderDao

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

                    INSTANCE = builder
//                        .fallbackToDestructiveMigration()
                        .createFromAsset("database/main_db.db")
                        .build()
                    return INSTANCE!!
                }
                return INSTANCE!!
            }
        }
    }
}

