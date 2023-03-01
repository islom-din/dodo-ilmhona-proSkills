package islom.din.dodo_ilmhona_proskills.khq.dbMain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import islom.din.dodo_ilmhona_proskills.QA.Constants

@Entity(tableName = "order_in_busket")
data class Order (
    @PrimaryKey(autoGenerate = true) val order_number : Int = 0,
    @ColumnInfo("user_id") val userId : Int,
)