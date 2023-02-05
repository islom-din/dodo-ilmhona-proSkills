package islom.din.dodo_ilmhona_proskills.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Vkus(
    val id : Int,
    val image : Int,
    val name : String,
    val price : Map<String,Int>,
    val available : Boolean = true,
    var select : Boolean = false,
) : Parcelable