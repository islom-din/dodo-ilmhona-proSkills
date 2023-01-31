package islom.din.dodo_ilmhona_proskills.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Pizza (
    val id : Int,
    val image : Int,
    val name : String,
    val about : String? = null,
    val price : Int,
    val category : String,
    val main : Boolean = false,
    val pizzasSizaPrise : Array<Int>? = null
) : Parcelable {
    fun formatPrice(): String {
        return "$price TJS"
    }
}