package islom.din.dodo_ilmhona_proskills.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ingridients(
    val id : Int,
    val image : Int? = null,
    val name : String,
    val price : Map<String,Int>? = null,
    val available : Boolean? = true,
    var delete : Boolean = false,
) : Parcelable