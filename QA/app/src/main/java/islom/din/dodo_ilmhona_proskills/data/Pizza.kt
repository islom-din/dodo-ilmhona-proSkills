package islom.din.dodo_ilmhona_proskills.data

data class Pizza (
    val id : Int,
    val image : Int,
    val name : String,
    val about : String? = null,
    val price : Int,
    val category : String,
    val main : Boolean = false,
    val pizzasSizaPrise : Array<Int>? = null,
    val litrArray : Array<Double>? = null,
    val shtuk : Int? = null,
        ) {
    fun formatPrice(): String {
        return "$price TJS"
    }

    fun formatLitr() : String {
        return "$price л"
    }
}