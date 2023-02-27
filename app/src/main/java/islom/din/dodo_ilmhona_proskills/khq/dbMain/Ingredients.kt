package islom.din.dodo_ilmhona_proskills.khq.dbMain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredients")
data class Ingredients(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var image: Int,
    var name: String,
    var available: Boolean = true,
    var selected: Boolean = false
)
