package islom.din.dodo_ilmhona_proskills.KHQ.dbMain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "order_connection", foreignKeys = [ForeignKey(Order::class,["id"],["order_id"], onDelete = ForeignKey.CASCADE),
    ForeignKey(Products::class,["id"],["product_id"], onDelete = ForeignKey.CASCADE)])
data class OrderConnection (
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo("order_id") val orderId : Int,
    @ColumnInfo("product_id") val productId : Int,
)
