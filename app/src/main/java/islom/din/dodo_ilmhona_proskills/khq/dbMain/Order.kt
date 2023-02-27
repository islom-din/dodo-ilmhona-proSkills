package islom.din.dodo_ilmhona_proskills.khq.dbMain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import islom.din.dodo_ilmhona_proskills.QA.Constants

@Entity(tableName = "order_my", indices = [Index(value = ["user_id"], unique = true)])
data class Order (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo("user_id") val userId : Int = Constants.USER_ID
)