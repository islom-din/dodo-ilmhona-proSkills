package islom.din.dodo_ilmhona_proskills.db

//@Database(
//    entities = [MPizza::class],
//    version = 1
//)
//abstract class DataBase : RoomDatabase() {
//
//    abstract fun ingredientsDao() : IngredientsDao
//
//    abstract fun ingredientProductsConnectionDao() : IngredientsProductsConnectionDao
//
//    abstract fun productsDao() : ProductsDao
//
//    companion object {
//        @Volatile
//        private var INSTANCE: DataBase? = null
//
//        public fun getInstance(context: Context): DataBase {
//            synchronized(this) {
//
//                if (INSTANCE == null) {
//                    // мы еще ни разу не создавали БД
//                    val builder = Room.databaseBuilder(
//                        context.applicationContext,
//                        DataBase::class.java,
//                        "main_db"
//                    )
//
//                    INSTANCE = builder.build()
//                    return INSTANCE!!
//                }
//                // БД уже была создана
//                return INSTANCE!!
//            }
//        }
//    }
//}