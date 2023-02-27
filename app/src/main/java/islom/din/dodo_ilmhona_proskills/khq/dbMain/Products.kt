package islom.din.dodo_ilmhona_proskills.khq.dbMain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Products (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val name : String,
    val image : Int,
    val price : Int?,
    val category : String,
    val about : String? = null,
)