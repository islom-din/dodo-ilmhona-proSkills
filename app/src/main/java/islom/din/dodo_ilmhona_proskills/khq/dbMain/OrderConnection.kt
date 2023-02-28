package islom.din.dodo_ilmhona_proskills.khq.dbMain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import islom.din.dodo_ilmhona_proskills.QA.Constants

@Entity(tableName = "order_connection", foreignKeys = [ForeignKey(Order::class,["order_number"],["order_number"], onDelete = ForeignKey.CASCADE),
    ForeignKey(Products::class,["id"],["product_id"], onDelete = ForeignKey.CASCADE)])
data class OrderConnection (
    @PrimaryKey(autoGenerate = true) @ColumnInfo("order_connection_id") val orderConnectionId : Int = 0,
    @ColumnInfo("order_number") val order_number : Int,
    @ColumnInfo("product_id") val productId : Int,
    val amount : Int,
)
