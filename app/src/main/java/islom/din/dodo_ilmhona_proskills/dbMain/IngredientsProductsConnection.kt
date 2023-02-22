package islom.din.dodo_ilmhona_proskills.dbMain

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import islom.din.dodo_ilmhona_proskills.QA.data.Ingridients

@Entity(tableName = "ingredients_products_connection", foreignKeys = [ForeignKey(entity = Products::class, parentColumns = ["id"], childColumns = ["products_id"], onDelete = ForeignKey.CASCADE),
ForeignKey(entity = Ingredients::class, parentColumns = ["id"], childColumns = ["ingredients_id",], onDelete = ForeignKey.CASCADE)],
indices = [Index(value = ["ingredients_id","products_id"], unique = true)])
data class IngredientsProductsConnection(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val ingredients_id : Int,
    val products_id: Int,
)
