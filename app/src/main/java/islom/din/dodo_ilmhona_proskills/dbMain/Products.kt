package islom.din.dodo_ilmhona_proskills.dbMain

import androidx.room.Entity
import androidx.room.PrimaryKey
import islom.din.dodo_ilmhona_proskills.QA.data.Ingridients

@Entity(tableName = "products")
data class Products (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val name : String,
    val image : Int,
    val price : Int,
    val category : String,
    val about : String? = null,
)