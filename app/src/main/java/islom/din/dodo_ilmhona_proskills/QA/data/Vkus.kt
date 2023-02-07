package islom.din.dodo_ilmhona_proskills.QA.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Vkus(
    val id : Int,
    val image : Int,
    val name : String,
    val price : Map<String,Int>? = null,
    val available : Boolean? = true,
    val select : Boolean? = false,
) : Parcelable