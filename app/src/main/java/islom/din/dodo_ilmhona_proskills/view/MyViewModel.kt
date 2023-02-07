package islom.din.dodo_ilmhona_proskills.view

import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.model.Constants
import islom.din.dodo_ilmhona_proskills.model.Pizza
import islom.din.dodo_ilmhona_proskills.model.Sous

class MyViewModel {

    fun Sous():MutableList<Pizza>{
        val list = (mutableListOf<Pizza>())
        list.add(Pizza(id = 55, image = R.raw.img_55, name = "Сырный соус",
            price = 5, category = Constants.SOUSI, shtuk = 1, main = true))

        list.add(Pizza(id = 56, image = R.raw.img_56, name = "Барбекю",
            price = 5, category = Constants.SOUSI, shtuk = 1))

        list.add(Pizza(id = 57, image = R.raw.img_57, name = "Чесночный",
            price = 5, category = Constants.SOUSI, shtuk = 1))

        return list
    }

    fun Desert():MutableList<Pizza>{
        val list = mutableListOf<Pizza>()
        list.add(Pizza(id = 44, image = R.raw.img_44, name = "Рулетки с корицей", about = "Сытные сладкие рулетки с корицей",
            price = 22, category = Constants.DESERTI,main = true))

        list.add(Pizza(id = 45, image = R.raw.img_45, name = "Чизкейк Нюь-Йорк", about = "Классические американские творожный десерт",
            price = 23, category = Constants.DESERTI, shtuk = 1))

        list.add(Pizza(id = 46, image = R.raw.img_46, name = "Маффин Три шоколада", about = "Десерт из натурального какао, нежной начинки на основе шоколада и кубиков белого и молочного шоколада",
            price = 12, category = Constants.DESERTI, shtuk =1 ))

        list.add(Pizza(id = 47, image = R.raw.img_47, name = "Кукис Три шоколада", about = "Большое нежное печенье с кусочками бельгийского молочного, тёмного и белого шоколада",
            price = 11, category = Constants.DESERTI, shtuk = 1))
        return list
    }

    fun Zakuski():MutableList<Pizza>{
        val list = mutableListOf<Pizza>()
        list.add(Pizza(id = 32, image = R.raw.img_32, name = "Додстер", about = "Легендарная горячая закуска с цыплёнком, томатами, моцареллой, соусом ранч в тонкой пшеничной лепешке",
            price = 25, category = Constants.ZAKUSKI, main = true, shtuk = 1))

        list.add(Pizza(id = 33, image = R.raw.img_33 , name = "Острый Додстер", about = "Горячая закуска с цыплёнком, перцем халапенью, солеными огурчиками, томатами, моцареллой, и соусом барбекю в тонкой пшеничной лепешке",
            price = 25, category = Constants.ZAKUSKI, shtuk = 1))

        list.add(Pizza(id = 34, image = R.raw.img_34 , name = "Рулетики с сыром", about = "Сытные рулетики с моцареллой и сырным соусом",
            price = 27, category = Constants.ZAKUSKI, shtuk = 1))

        list.add(Pizza(id = 35, image = R.raw.img_35 , name = "Рулетики с пепперони, 16 шт.", about = "Горячие рулетики с колбасками пепперони, моцареллой и сырнымм соусом",
            price = 27, category = Constants.ZAKUSKI, shtuk = 16))

        list.add(Pizza(id = 36, image = R.raw.img_36, name = "Рулетики с пепперони + Рулетики с сыром, 16 шт.", about = "Микс горячих рулетиков с сырным соусом, 8 штук с пепперони и моцареллой, 8 штук с моцареллой",
            price = 27, category = Constants.ZAKUSKI, shtuk = 16))

        list.add(Pizza(id = 37, image = R.raw.img_37 , name = "Картофель из печи", about = "Ароматный запеченный картофель с итальянскими травами",
            price = 28, category = Constants.ZAKUSKI))

        list.add(Pizza(id = 38, image = R.raw.img_38, name = "Стартер Грибной", about = "Горячая закуска с шампиньонами, моцареллой и соусом ранч в тонкой пшеничной лепешке",
            price = 25, category = Constants.ZAKUSKI, shtuk = 1))

        list.add(Pizza(id = 39, image = R.raw.img_39, name = "Мясной Стартер", about = "Горячая закуска с митболами из говядины, томатами, моцареллой, и пикатным соусом бурегер в тонкой пшеничной лепешке",
            price = 25, category = Constants.ZAKUSKI, shtuk = 1))

        list.add(Pizza(id = 40, image = R.raw.img_40, name = "Сырныр стартер", about = "Гораячая закуска с очень сырной начинкой. Моцарелла, пармезан, чеддери соус в тонкой пшеничной лепешке",
            price = 25, category = Constants.ZAKUSKI, shtuk = 1))

        list.add(Pizza(id = 41, image = R.raw.img_41, name = "Куриные кусочки", about = "Кусочки куриного филе в хрустящей панировке",
            price = 48, category = Constants.ZAKUSKI))

        list.add(Pizza(id = 42, image = R.raw.img_42, name = "Салаь Греческой с соусом бальзамик", about = "Салат айсберг, томаты черри, маслины, свежий огурец, кубики брынзы, соус бальзамик",
            price = 27, category = Constants.ZAKUSKI, shtuk = 1))

        list.add(Pizza(id = 43, image = R.raw.img_43, name = "Салат Цезарь", about = "Цыплёнок, свежие листья салата айсберг, томаты черри, сыры чеддер и пармезан, соус цезарь, пшеничные гренки, итальяские травы",
            price = 28, category = Constants.ZAKUSKI, shtuk = 1))
        return list
    }





    fun Napitki():MutableList<Pizza>{
        val list = mutableListOf<Pizza>()

        list.add(Pizza(id = 49, image = R.raw.img_49, name = "Coca-cola",
            price = 8, category = Constants.NAPITKI, main = true, litrArray = arrayOf(0.33,0.5,1.25)))

        list.add(Pizza(id = 48, image = R.raw.img_48, name = "Coca-Cola Zero",
            price = 8, category = Constants.NAPITKI, litrArray = arrayOf(0.5) ))

        list.add(Pizza(id = 50, image = R.raw.img_50, name = "Sprite",
            price = 8, category = Constants.NAPITKI, litrArray = arrayOf(0.5,1.0) ))

        list.add(Pizza(id = 51, image = R.raw.img_51, name = "Fanta",
            price = 8, category = Constants.NAPITKI, litrArray = arrayOf(0.5,1.25) ))

        list.add(Pizza(id = 52, image = R.raw.img_52, name = "Fusetea, 0,5л",
            price = 8, category = Constants.NAPITKI, litrArray = arrayOf(0.5) ))

        list.add(Pizza(id = 53, image = R.raw.img_53, name = "БонАква негаз",
            price = 5, category = Constants.NAPITKI, litrArray = arrayOf(0.5)
        ))

        list.add(Pizza(id = 54, image = R.raw.img_54, name = "Сок Добрый 1л",
            price = 28, category = Constants.NAPITKI, litrArray = arrayOf(1.0) ))

        return list
    }


    fun Pizza():MutableList<Pizza>{
        var list = mutableListOf<Pizza>()
        list.add(Pizza(1, R.raw.img_1,"Новогодный цыплёнок","Смесь сыров чеддре и пармезан, соус альфредо, мандарины,цитрусовый соус, новогодный цеплёнок, сыр моцарелла",
            60, Constants.PIZZA,true, arrayOf(25,30,35)))

        list.add(Pizza(2, R.raw.img_2,"Буршер пицца","Красный лук, сольёные огурчики, томаты, соус бургер, ветчина залясь, сыр моцарелла",
            54, Constants.PIZZA,false , arrayOf(25,30,35)))

        list.add(Pizza(3, R.raw.img_3,"Аррива","Сыр моцарелла, соус бургер,цыплёнок, соус ранч, острая чоризо из цыплёнка, сладкий перец, красный лук, томаты, чеснок",
            54, Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(4, R.raw.img_4,"Пепперони","Пепперони из цыплёнка, томатный соус, увеличенная порция моцареллы",
            54, Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(5, R.raw.img_5,"Додо","Ветчина из цыплёнка, митоболы из говядины, пикантная пепперони из цыплёнка, томаты, шампиньоны, сладкий перей, красный лук, чеснок, томатный соус, моцарелла",
            60, Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(6, R.raw.img_6,"Диалбло","Острая чоризо из цыплёнка, острый перец холапеньо, соус барбекю, митболы из говядины, томаты, сладкий перец, красный лук, томатный соус, моцарелла",
            58, Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(7, R.raw.img_7,"Сырная","Смесь сыров чеддер и пармезан соус альфредо, моцарелла",
            39, Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(9, R.raw.img_9,"Пепперони Фреш","Пикатна пепперони из цыплёнка, томаты, томаный соус, увеличенная порция моцаррелы",
            37, Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(10, R.raw.img_10,"Мясная","Цыплёнок, ветчина из цыплёнка, пикантная пепперони из цыплёнка, томатный соус, острая чоризо из цыплёнка, сыр моцарелла",
            60, Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(11, R.raw.img_11,"Маргарита","Томаты, итальянские травы, томатный соус, увеличенная порция моцареллы",
            44, Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(12, R.raw.img_12,"Песто","Соус песто, соус альфредо, цыплёнок, кубики брынзы, томаты, моцарелла",
            60, Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(13, R.raw.img_13,"Двойная пепперони","Пепперони из цыплёнка, томатный соус, моцарелла",
            60, Constants.PIZZA,false, arrayOf(25,30,35)))

        return list
    }




        fun getListCous(): List<Sous> {
            val list = mutableListOf<Sous>(
                Sous(1, R.drawable.sirniy_bortikpng, "Сырный бортик", 25),
                Sous(1, R.drawable.brinzapng, "sousoso", 25),
                Sous(1, R.drawable.siplyonok, "sousoso", 25),
                Sous(1, R.drawable.govyadinapng, "sousoso", 25),
                Sous(1, R.drawable.krasniy_lukpng, "sousoso", 25),
                Sous(1, R.drawable.maslinipng, "sousoso", 25),
                Sous(1, R.drawable.ogursipng, "sousoso", 25),
                Sous(1, R.drawable.pipperonipng, "sousoso", 25),
                Sous(1, R.drawable.perecpng, "sousoso", 25),
                Sous(1, R.drawable.travipng, "sousoso", 25)
            )
            return list
        }

        fun getListCous1(): List<Sous> {
            val list = mutableListOf<Sous>(
                Sous(1, R.drawable.govyadinapng, "sousoso", 18),
                Sous(1, R.drawable.govyadinapng, "sousoso", 18),
                Sous(1, R.drawable.govyadinapng, "sousoso", 18),
                Sous(1, R.drawable.govyadinapng, "sousoso", 18),
                Sous(1, R.drawable.govyadinapng, "sousoso", 18),
                Sous(1, R.drawable.govyadinapng, "sousoso", 18),
                Sous(1, R.drawable.govyadinapng, "sousoso", 18),
                Sous(1, R.drawable.govyadinapng, "sousoso", 18),

                )
            return list
        }

        fun getListCous2(): List<Sous> {
            val list = mutableListOf<Sous>(
                Sous(1, R.drawable.halapenopng, "sousoso", 10),
                Sous(1, R.drawable.halapenopng, "sousoso", 10),
                Sous(1, R.drawable.halapenopng, "sousoso", 10),
                Sous(1, R.drawable.halapenopng, "sousoso", 10),
                Sous(1, R.drawable.halapenopng, "sousoso", 10),
                Sous(1, R.drawable.halapenopng, "sousoso", 10),
                Sous(1, R.drawable.halapenopng, "sousoso", 10),
                Sous(1, R.drawable.halapenopng, "sousoso", 10),

                )
            return list
        }
}
