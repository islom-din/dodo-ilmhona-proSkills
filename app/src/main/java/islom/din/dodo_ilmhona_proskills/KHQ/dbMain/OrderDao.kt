package islom.din.dodo_ilmhona_proskills.KHQ.dbMain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface OrderDao {
    @Insert
    suspend fun newOrder(order: Order)

    @Query("SELECT * FROM order WHERE user_id = :user_id")
    fun getOrderId(user_id : Int) : List<Order>

    @Insert
    suspend fun newOrderConnection(orderConnection : OrderConnection)

    @Query("SELECT id,name,image,price,category,about FROM products as p INNER JOIN order_connection as o " +
            "ON p.id = o.order_id AND o.order_id = :order_id")
    fun getOrderedProducts(order_id : Int) : List<Products>
}