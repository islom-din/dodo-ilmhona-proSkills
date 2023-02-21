package com.example.order


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
    val arrayCategory: Array<String>? = null,
        )