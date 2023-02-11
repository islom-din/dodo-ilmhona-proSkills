package islom.din.dodo_ilmhona_proskills.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pizza")
data class MPizza(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: Int,
)

/// ----id-----name--------price ------ description
// -----1------Dodo--------7000 -------- null
// -----2------Diablo--------10000 ------ null