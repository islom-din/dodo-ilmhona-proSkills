package islom.din.dodo_ilmhona_proskills.repository


import islom.din.dodo_ilmhona_proskills.Constants
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.model.Pizza

class GetPizzaList {
    fun getList(): List<Pizza> {
        val list = mutableListOf<Pizza>()
        repeat(5) {
            list.add(
                Pizza(
                    1,
                    R.drawable.ingridient_1,
                    "Новогодный цыплёнок",
                    "Смесь сыров чеддре и пармезан, соус альфредо, мандарины,цитрусовый соус, новогодный цеплёнок, сыр моцарелла",
                    60,
                    Constants.PIZZA,
                    true,
                    mapOf(
                        Constants.MALENKAYA to 60,
                        Constants.SREDNAYA to 90,
                        Constants.BOLSHAYA to 112
                    )
                )
            )
        }
        return list
    }
}