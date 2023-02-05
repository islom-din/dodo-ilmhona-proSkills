package islom.din.dodo_ilmhona_proskills.model

import android.os.Parcelable
import islom.din.dodo_ilmhona_proskills.data.Vkus
import kotlinx.android.parcel.Parcelize


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
    val vkusList: Array<Vkus>? = null,
    val arrayCategory : Array<String>? = null,
    val litrArray : Array<Double>? = null,
    val shtuk : Int? = null,
        ) : Parcelable{

    fun formatPrice(): String {
        return "$price TJS"
    }

    fun formatLitr() : String {
        return "$price л"
    }
}