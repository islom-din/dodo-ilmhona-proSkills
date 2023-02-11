package islom.din.dodo_ilmhona_proskills.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [MPizza::class],
    version = 1
)
abstract class DataBase : RoomDatabase() {

    abstract fun pizzaDao(): PizzaDao

    companion object {
        @Volatile
        private var INSTANCE: DataBase? = null

        public fun getInstance(context: Context): DataBase {
            synchronized(this) {

                if (INSTANCE == null) {
                    // мы еще ни разу не создавали БД
                    val builder = Room.databaseBuilder(
                        context.applicationContext,
                        DataBase::class.java,
                        "pizza_db"
                    )

                    INSTANCE = builder.build()
                    return INSTANCE!!
                }
                // БД уже была создана
                return INSTANCE!!
            }
        }
    }
}