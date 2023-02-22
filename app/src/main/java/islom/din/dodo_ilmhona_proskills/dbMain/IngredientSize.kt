package islom.din.dodo_ilmhona_proskills.dbMain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredient_size")
data class IngredientSize(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo("ingredient_size") val ingredientSize : String
    )
