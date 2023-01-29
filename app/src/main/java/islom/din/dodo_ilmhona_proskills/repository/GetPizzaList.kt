package islom.din.dodo_ilmhona_proskills.repository

import islom.din.dodo_ilmhona_proskills.Constants
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.data.Pizza

class GetPizzaList {
    fun getList(): List<Pizza> {
        val list = mutableListOf<Pizza>()
        repeat(5) {
            list.add(
                Pizza(
                    id = it,
                    image = R.drawable.pizza_1,
                    name = "2 пиццы и напиток",
                    about = "2 пиццы 25 см и напиток на выбор. Для компании из 2-4 человек",
                    price = 94,
                    category = Constants.PIZZA,
                    pizzasSizaPrise = arrayOf(25,30,35)
                )
            )
        }
        repeat(5) {
            list.add(
                Pizza(
                    id = it,
                    image = R.drawable.coca_cola,
                    name = "Coca-Cola Zero",
                    price = 8,
                    category = Constants.NAPITKI
                )
            )
        }
        repeat(4) {
            list.add(
                Pizza(
                    id = it,
                    R.drawable.combo,
                    name = "10 medium pizzas",
                    about = "10 pizzas 40sm for every taste. For a company of 20-30 people",
                    price = 675,
                    category = Constants.COMBO
                )
            )
        }
        return list
    }
}