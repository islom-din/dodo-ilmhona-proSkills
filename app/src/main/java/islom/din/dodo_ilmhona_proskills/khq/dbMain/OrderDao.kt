package islom.din.dodo_ilmhona_proskills.khq.dbMain

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {
    @Query("SELECT order_number FROM order_in_busket WHERE user_id = :user_id")
    fun getOrderNumber(user_id: Int) : Int

    @Query("DELETE FROM order_in_busket WHERE order_number = :order_number")
    fun deleteOrder(order_number: Int)

    @Query("SELECT * FROM order_connection WHERE order_number = :order_number")
    fun getOrderByUserId(order_number: Int) : List<OrderConnection>

    @Query("UPDATE order_connection SET amount = :amount " +
            "WHERE order_number = :order_number AND product_id = :product_id")
    fun updateOrderAmount(amount: Int,order_number: Int,product_id : Int)

    @Insert
    fun insertOrderHistory(listOrderHistory: OrderHistory)

    @Insert
    suspend fun newOrderConnection(orderConnection : OrderConnection)

    @RewriteQueriesToDropUnusedColumns
    @Query("SELECT * FROM products as p INNER JOIN order_connection as o " +
            "ON p.id = o.product_id AND o.order_number = :order_number")
    fun getOrderedProducts(order_number: Int) : Flow<List<Products>>

    @Query("SELECT SUM(p.price * o.amount) FROM products as p INNER JOIN order_connection as o " +
            "ON p.id = o.product_id AND o.order_number = :order_number")
    fun getProductsSum(order_number: Int) : Flow<Int>

    @Query("SELECT amount FROM order_connection WHERE order_number = :order_number")
    fun getOrderedAmount(order_number: Int) : Flow<List<Int>>

    @Query("DELETE FROM order_connection WHERE order_number = :order_number AND product_id = :product_id")
    fun deleteOrder(order_number: Int,product_id: Int)

    @Insert
    fun insertNewOrder(order: Order)
}