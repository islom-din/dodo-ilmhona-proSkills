package islom.din.dodo_ilmhona_proskills.KHQ.dbMain

import android.view.inspector.IntFlagMapping
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "order")
data class Order (
    @PrimaryKey(autoGenerate = true) val id : Int,
    val user_id : Int = 0,
    val done : Boolean = false,
)