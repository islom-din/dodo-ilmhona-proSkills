package islom.din.dodo_ilmhona_proskills.dbMain

import androidx.room.*

@Entity(tableName = "ingredient_size_connection", foreignKeys = [ForeignKey(entity = IngredientSize::class, parentColumns = ["id"], childColumns = ["size_id"], onDelete = ForeignKey.CASCADE),
ForeignKey(entity = Ingredients::class, parentColumns = ["id"], childColumns = ["ingredient_id"], onDelete = ForeignKey.CASCADE)],
    indices = [Index(value = ["ingredient_id","size_id","price"], unique = true)])
data class IngredientSizeConnection(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo("ingredient_id") val ingredientId : Int,
    @ColumnInfo("size_id") val sizeId : Int,
    @ColumnInfo("price") val price : Int
)
