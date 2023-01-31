package islom.din.dodo_ilmhona_proskills.repository


import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.data.Pizza

class GetPizzaList {
    fun getList(): List<Pizza> {
        val list = mutableListOf<Pizza>()
        repeat(5) {
            list.add(
                Pizza(
                    id = it,
                    image = R.drawable.govyadinapng,
                    name = "2 РїРёС†С†С‹ Рё РЅР°РїРёС‚РѕРє",
                    about = "2 РїРёС†С†С‹ 25 СЃРј Рё РЅР°РїРёС‚РѕРє РЅР° РІС‹Р±РѕСЂ. Р”Р»СЏ РєРѕРјРїР°РЅРёРё РёР· 2-4 С‡РµР»РѕРІРµРє",
                    price = 94,
                    category = "PIZZA",
                    pizzasSizaPrise = arrayOf(25,30,35)
                )
            )
        }
        repeat(5) {
            list.add(
                Pizza(
                    id = it,
                    image = R.drawable.halapenopng,
                    name = "Coca-Cola Zero",
                    price = 8,
                    category = "Dring"
                )
            )
        }
        repeat(4) {
            list.add(
                Pizza(
                    id = it,
                    R.drawable.siplyonok,
                    name = "10 medium pizzas",
                    about = "10 pizzas 40sm for every taste. For a company of 20-30 people",
                    price = 675,
                    category = "Combo"
                )
            )
        }
        return list
    }
}