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
    val pizzasSizePrise : Map<String,Int>? = null,
    val ingridientList: MutableList<Ingridients>? = null,
    val arrayCategory : Array<String>? = null,
    val litrArray : Array<Double>? = null,
    val shtuk : Int? = null,
        ) : Parcelable {

    fun formatPrice(): String {
        return "$price TJS"
    }

    fun formatLitr() : String {
        return "$price л"
    }
}