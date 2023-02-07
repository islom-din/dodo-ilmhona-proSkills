package islom.din.dodo_ilmhona_proskills.QA.repository

import islom.din.dodo_ilmhona_proskills.QA.data.Ingridients


class GetIngridientList()  {
    fun getList() : MutableList<Ingridients> {

        val list = mutableListOf<Ingridients>()

        list.add(Ingridients(id = 0, name = "NOTHING"))
        list.add(Ingridients(id = 1, name = "Соус альфредо",false))
        list.add(Ingridients(id = 2, name = "Мандарины"))
        list.add(Ingridients(id = 3 , name = "Цитровый соус",false))
        list.add(Ingridients(id = 4 , name = "Новогодгый соус",))
        list.add(Ingridients(id = 5 , name = "Cыр моцарелла",false))
        list.add(Ingridients(id = 6 , name = "Красный лук"))
        list.add(Ingridients(id = 7 , name = "Солёные огурчики"))
        list.add(Ingridients(id = 8 , name = "Томаты"))
        list.add(Ingridients(id = 9 , name = "Соус бургер",false))
        list.add(Ingridients(id = 10 , name = "Ветчина халяль",false))
        list.add(Ingridients(id = 11 , name = "Сыр моцарелла",false))
        list.add(Ingridients(id = 12 , name = "Цыплёнок"))
        list.add(Ingridients(id = 13 , name = "Соус ранч"))
        list.add(Ingridients(id = 14 , name = "Острая чоризо из цыплёнка"))
        list.add(Ingridients(id = 15 , name = "Сладкий перец"))
        list.add(Ingridients(id = 16 , name = "Чеснок"))
        list.add(Ingridients(id = 17 , name = "Пепперони из цыплёнка"))
        list.add(Ingridients(id = 18 , name = "Томатный соус",false))
        list.add(Ingridients(id = 19 , name = "Увеличенная порция моцареллы",false))
        list.add(Ingridients(id = 20 , name = "NOTHING",false))
        list.add(Ingridients(id = 21 , name = "Ветчина из цыплёнка"))
        list.add(Ingridients(id = 22 , name = "Митболы из говдины"))
        list.add(Ingridients(id = 23 , name = "Пикатная пепперони из цыплёнка"))
        list.add(Ingridients(id = 24 , name = "Шампиньоны"))
        list.add(Ingridients(id = 25 , name = "Моцарелла"))
        list.add(Ingridients(id = 26 , name = "Острый перец халапеньо"))
        list.add(Ingridients(id = 27 , name = "Соус барбекю"))
        list.add(Ingridients(id = 28 , name = "Митболы из говядины"))
        list.add(Ingridients(id = 29 , name = "Томаты"))
        list.add(Ingridients(id = 30 , name = "Томаты"))

        var couter = 31
        var text = "Смесь сыров чеддер и пармезан, соус альфредо, моцарелла".split(",")

        for (i in text){
            list.add(Ingridients(id = couter, name = i))
            couter++
        }

        text = "Пикатна пепперони из цыплёнка, том аты, томаный соус, увеличенная порция моцаррелы".split(",")
        for (i in text){
            list.add(Ingridients(id = couter, name = i))
            couter++
        }

        text = "Цыплёнок, ветчина из цыплёнка, пикантная пепперони из цыплёнка, томатный соус, острая чоризо из цыплёнка, сыр моцарелла".split(",")
        for (i in text){
            list.add(Ingridients(id = couter, name = i))
            couter++
        }

        text = "Томаты, итальянские травы, томатный соус, увеличенная порция моцареллы".split(",")
        for (i in text){
            list.add(Ingridients(id = couter, name = i))
            couter++
        }

        text = "Соус песто, соус альфредо, цыплёнок, кубики брынзы, томаты, моцарелла".split(",")
        for (i in text){
            list.add(Ingridients(id = couter, name = i))
            couter++
        }

        text = "Пепперони из цыплёнка, томатный соус, моцарелла".split(",")
        for (i in text){
            list.add(Ingridients(id = couter, name = i))
            couter++
        }

        text = "Цыплёнок, соу альфредо, моцарелла".split(",")
        for (i in text){
            list.add(Ingridients(id = couter, name = i))
            couter++
        }

        text = "Ветчина из цыплёнка, сыр моцарелла, соус альфредо".split(",")
        for (i in text){
            list.add(Ingridients(id = couter, name = i))
            couter++
        }

        text = "Увеличенная порция моцареллы, смесь сыров чеддер и пармезан, сыр блю чиз, соус фльфредо".split(",")
        for (i in text){
            list.add(Ingridients(id = couter, name = i))
            couter++
        }

        text = "Увеличенная порция моцареллы, смесь сыров чеддер и пармезан, сыр блю чиз, соус альфредо".split(",")
        for (i in text){
            list.add(Ingridients(id = couter, name = i))
            couter++
        }

        text = "Сыр моцарлла, ветчина из цыплёнка, пикантная пепперони из цыплёнка, кубики брынзф, томаты, шампиньогы, томатный соус, итальянские травы".split(",")
        for (i in text){
            list.add(Ingridients(id = couter, name = i))
            couter++
        }

        text = "Картофель из печи, огурцы маринованные, цыплёнок, соус, чесночный ранч, томаты свежие, лук красный, чеснок, пицца-соус, сыр моцалрелла".split(",")
        for (i in text){
            list.add(Ingridients(id = couter, name = i))
            couter++
        }

        text = "Ветчина из цыплёнка, шампиньоны, томатный соус, увеличенная порция моцареллы".split(",")
        for (i in text){
            list.add(Ingridients(id = couter, name = i))
            couter++
        }






        return list
    }
}