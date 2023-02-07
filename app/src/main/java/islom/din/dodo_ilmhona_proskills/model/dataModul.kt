package islom.din.dodo_ilmhona_proskills.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import islom.din.dodo_ilmhona_proskills.R

class DataViewModel : ViewModel() {
    val pizza = MutableLiveData<List<Pizza>>()
    lateinit var combo :Pizza
    var list = mutableListOf<Pizza>()
    var choosePizzaPosition = -1

    init {
        list = mutableListOf()

         combo = Pizza(
            25,
            R.raw.img_25,
            "2 пиццы и напиток",
            "2 пиццы 25 см и напиток на выбор, Для компании из 2-4 человек",
            99,
            Constants.COMBO,
            arrayCategory = arrayOf(Constants.PIZZA, Constants.PIZZA, Constants.NAPITKI)
        )

        if (combo.arrayCategory != null)
            for (i in combo.arrayCategory!!) {
                if (i == Constants.PIZZA) {
                    (list.add(
                        Pizza(
                            13,
                            R.raw.img_13,
                            "Двойная пепперони",
                            "Пепперони из цыплёнка, томатный соус, моцарелла",
                            60,
                            Constants.PIZZA,
                            false,
                            arrayOf(25, 30, 35)
                        )
                    ))
                } else if (i == Constants.NAPITKI) {
                    list.add(
                        Pizza(
                            id = 51, image = R.raw.img_51, name = "Fanta",
                            price = 8, category = Constants.NAPITKI, litrArray = arrayOf(0.5, 1.25)
                        )
                    )
                } else if (i == Constants.DESERTI) {
                    list.add(
                        Pizza(
                            id = 47,
                            image = R.raw.img_47,
                            name = "Кукис Три шоколада",
                            about = "Большое нежное печенье с кусочками бельгийского молочного, тёмного и белого шоколада",
                            price = 11,
                            category = Constants.DESERTI,
                            shtuk = 1
                        )
                    )
                } else if (i == Constants.ZAKUSKI) {
                    list.add(
                        Pizza(
                            id = 43,
                            image = R.raw.img_43,
                            name = "Салат Цезарь",
                            about = "Цыплёнок, свежие листья салата айсберг, томаты черри, сыры чеддер и пармезан, соус цезарь, пшеничные гренки, итальяские травы",
                            price = 28,
                            category = Constants.ZAKUSKI,
                            shtuk = 1
                        )
                    )
                } else if (i == Constants.DRUGIE) {
                    list.add(
                        Pizza(
                            id = 58, image = R.raw.img_58, name = "Додо Раскарска",
                            price = 2, category = Constants.DRUGIE, shtuk = 1
                        )
                    )
                } else if (i == Constants.SOUSI) {
                    list.add(
                        Pizza(
                            id = 55, image = R.raw.img_55, name = "Сырный соус",
                            price = 5, category = Constants.SOUSI, shtuk = 1, main = true
                        )
                    )
                }
            }

        pizza.postValue(list)
    }



    fun pizzaChanged(p: Pizza) {
        val changedList = mutableListOf<Pizza>()

        list.forEachIndexed { index, pizza ->
            if (index != choosePizzaPosition)
                changedList.add(pizza)
            else {
                changedList.add(p)
                choosePizzaPosition = -1
            }
        }

        list = changedList

        pizza.postValue(changedList)
    }

}