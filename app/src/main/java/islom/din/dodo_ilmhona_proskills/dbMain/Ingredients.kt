package islom.din.dodo_ilmhona_proskills.dbMain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredients")
data class Ingredients(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    private val image: Int,
    private val name: String,
    private val available: Boolean = true,
    private val selected: Boolean = false
    private val prise : //TODO another new entity?,
)
