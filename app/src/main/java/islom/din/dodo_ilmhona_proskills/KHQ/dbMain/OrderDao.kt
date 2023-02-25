package islom.din.dodo_ilmhona_proskills.KHQ.dbMain

import androidx.room.*

@Dao
interface OrderDao {
    @Insert
    suspend fun newOrder(order: Order)

    @Insert
    suspend fun newOrderConnection(orderConnection : OrderConnection)

    @RewriteQueriesToDropUnusedColumns
    @Query("SELECT * FROM products as p INNER JOIN order_connection as o " +
            "ON p.id = o.order_id AND o.user_id = :user_id")
    fun getOrderedProducts(user_id: Int) : List<Products>
}