package islom.din.dodo_ilmhona_proskills.khq.dbMain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "order_history", foreignKeys = [ForeignKey(Order::class,["order_number"],["order_number"], onDelete = ForeignKey.CASCADE),
    ForeignKey(Products::class,["id"],["product_id"], onDelete = ForeignKey.CASCADE)])
data class OrderHistory (
    @PrimaryKey(autoGenerate = true) @ColumnInfo("order_history_id") val orderHistoryId : Int = 0,
    @ColumnInfo("order_number") val order_number : Int,
    @ColumnInfo("product_id") val productId : Int,
    val amount : Int,
        )