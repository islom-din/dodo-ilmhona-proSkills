package islom.din.dodo_ilmhona_proskills.dbMain

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "pizza_prices",
    foreignKeys =  [ForeignKey(entity = Products::class, parentColumns = ["id"], childColumns = ["pizza_id"], onDelete = ForeignKey.CASCADE)])
data class PizzaPrices(
    @PrimaryKey(autoGenerate = true) private val id : Int = 0,
    private val pizza_id : Int,
    private val price: Int
)
