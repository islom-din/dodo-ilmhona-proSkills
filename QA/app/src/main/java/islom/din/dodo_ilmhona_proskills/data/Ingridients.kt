package islom.din.dodo_ilmhona_proskills.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ingridients(
    val id : Int,
    val name : String,
    val available : Boolean = true,
    val delete : Boolean = false
) : Parcelable