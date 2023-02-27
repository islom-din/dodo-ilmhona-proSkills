package islom.din.dodo_ilmhona_proskills.khq.dbMain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import islom.din.dodo_ilmhona_proskills.QA.Constants

@Entity(tableName = "order_connection_server", foreignKeys = [ForeignKey(Order::class,["user_id"],["user_id"], onDelete = ForeignKey.CASCADE),
    ForeignKey(Products::class,["id"],["product_id"], onDelete = ForeignKey.CASCADE)])
data class OrderConnectionServer (
    @PrimaryKey(autoGenerate = true) @ColumnInfo("order_id") val orderId : Int = 0,
    @ColumnInfo("user_id") val userId: Int = Constants.USER_ID,
    @ColumnInfo("product_id") val productId: Int,
    val amount: Int,
)