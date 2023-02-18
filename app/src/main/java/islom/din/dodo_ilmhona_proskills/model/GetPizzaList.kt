package islom.din.dodo_ilmhona_proskills.model


import islom.din.dodo_ilmhona_proskills.R


class GetPizzaList {
    fun getList(): List<Pizza> {
        val list = mutableListOf<Pizza>()

        list.add(Pizza(1, R.raw.img_1,"Новогодный цыплёнок","Смесь сыров чеддре и пармезан, соус альфредо, мандарины,цитрусовый соус, новогодный цеплёнок, сыр моцарелла",
        60,Constants.PIZZA,true, arrayOf(25,30,35)))

        list.add(Pizza(2, R.raw.img_2,"Буршер пицца","Красный лук, сольёные огурчики, томаты, соус бургер, ветчина залясь, сыр моцарелла",
            54,Constants.PIZZA,false , arrayOf(25,30,35)))

        list.add(Pizza(3, R.raw.img_3,"Аррива","Сыр моцарелла, соус бургер,цыплёнок, соус ранч, острая чоризо из цыплёнка, сладкий перец, красный лук, томаты, чеснок",
            54,Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(4, R.raw.img_4,"Пепперони","Пепперони из цыплёнка, томатный соус, увеличенная порция моцареллы",
            54,Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(5, R.raw.img_5,"Додо","Ветчина из цыплёнка, митоболы из говядины, пикантная пепперони из цыплёнка, томаты, шампиньоны, сладкий перей, красный лук, чеснок, томатный соус, моцарелла",
            60,Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(6, R.raw.img_6,"Диалбло","Острая чоризо из цыплёнка, острый перец холапеньо, соус барбекю, митболы из говядины, томаты, сладкий перец, красный лук, томатный соус, моцарелла",
            58,Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(7, R.raw.img_7,"Сырная","Смесь сыров чеддер и пармезан соус альфредо, моцарелла",
            39,Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(9, R.raw.img_9,"Пепперони Фреш","Пикатна пепперони из цыплёнка, томаты, томаный соус, увеличенная порция моцаррелы",
            37,Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(10, R.raw.img_10,"Мясная","Цыплёнок, ветчина из цыплёнка, пикантная пепперони из цыплёнка, томатный соус, острая чоризо из цыплёнка, сыр моцарелла",
            60,Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(11, R.raw.img_11,"Маргарита","Томаты, итальянские травы, томатный соус, увеличенная порция моцареллы",
            44,Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(12, R.raw.img_12,"Песто","Соус песто, соус альфредо, цыплёнок, кубики брынзы, томаты, моцарелла",
            60,Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(13, R.raw.img_13,"Двойная пепперони","Пепперони из цыплёнка, томатный соус, моцарелла",
            60,Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(14, R.raw.img_14,"Двойной цыплёнок","Цыплёнок, соу альфредо, моцарелла",
            37,Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(15, R.raw.img_15,"Ветчина и сыр","Ветчина из цыплёнка, сыр моцарелла, соус альфредо",
            39,Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(16, R.raw.img_16,"Карбонара","Увеличенная порция моцареллы, смесь сыров чеддер и пармезан, сыр блю чиз, соус фльфредо",
            60,Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(17, R.raw.img_17,"Четыре сыра","Увеличенная порция моцареллы, смесь сыров чеддер и пармезан, сыр блю чиз, соус альфредо",
            37,Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(18, R.raw.img_18,"Четыре сезона","Сыр моцарлла, ветчина из цыплёнка, пикантная пепперони из цыплёнка, кубики брынзф, томаты, шампиньогы, томатный соус, итальянские травы",
            58,Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(19, R.raw.img_19,"Деревенская","Картофель из печи, огурцы маринованные, цыплёнок, соус, чесночный ранч, томаты свежие, лук красный, чеснок, пицца-соус, сыр моцалрелла",
            58,Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(20, R.raw.img_20,"Ветчина и грибы","Ветчина из цыплёнка, шампиньоны, томатный соус, увеличенная порция моцареллы",
            44,Constants.PIZZA,false, arrayOf(25,30,35)))

        list.add(Pizza(21, R.raw.img_21,"3 пиццы","Комбо 2 пиццы 30см на любой вкус",
            225,Constants.COMBO,true, arrayCategory = arrayOf(Constants.PIZZA,Constants.PIZZA,Constants.PIZZA)
        ))

        list.add(Pizza(22, R.raw.img_22,"10 средних пицц","10 пицц 30см на любой вкусу. Для компании из 20-30 человек",
            675,Constants.COMBO,arrayCategory = arrayOf(Constants.PIZZA,Constants.PIZZA,Constants.PIZZA,Constants.PIZZA,Constants.PIZZA,Constants.PIZZA,Constants.PIZZA,Constants.PIZZA,Constants.PIZZA,Constants.PIZZA)))

        list.add(Pizza(23, R.raw.img_23,"2 пиццы","Самое популяроне комбо из 2 пицц 30см. Большой выбор",
            156,Constants.COMBO, arrayCategory = arrayOf(Constants.PIZZA,Constants.PIZZA)
        ))

        list.add(Pizza(24, R.raw.img_24,"7 пицц","7 пицц 30см на любой вкус. Для компании из 15-20 человек",
            470,Constants.COMBO,arrayCategory = arrayOf(Constants.PIZZA,Constants.PIZZA,Constants.PIZZA,Constants.PIZZA,Constants.PIZZA,Constants.PIZZA,Constants.PIZZA)))

        list.add(Pizza(25, R.raw.img_25,"2 пиццы и напиток","2 пиццы 25 см и напиток на выбор, Для компании из 2-4 человек",
            99,Constants.COMBO, arrayCategory = arrayOf(Constants.PIZZA,Constants.PIZZA,Constants.NAPITKI)
        ))

        list.add(Pizza(26, R.raw.img_26,"Пицца и 2 закуски","Пицца 30см и 2 закуски на выбор. Для компании из 2-4 человек",
            110,Constants.COMBO, arrayCategory = arrayOf(Constants.PIZZA,Constants.ZAKUSKI,Constants.ZAKUSKI)
        ))

        list.add(Pizza(27, R.raw.img_27,"4 Додстера","4 любых Додстера на выбор: Отсрый или Классический",
            89,Constants.COMBO, arrayCategory =  arrayOf(Constants.ZAKUSKI,Constants.ZAKUSKI,Constants.ZAKUSKI,Constants.ZAKUSKI)
        ))

        list.add(Pizza(28, R.raw.img_28,"Пицца, додстер, напиток и соус","Пицца 25см, додстер, напиток и соус. Для компании из 2-4 человек",
            85,Constants.COMBO, arrayCategory = arrayOf(Constants.PIZZA,Constants.ZAKUSKI,Constants.NAPITKI,Constants.SOUSI)
        ))

        list.add(Pizza(29, R.raw.img_29,"2 стартера","2 стартера",
            45,Constants.COMBO, arrayCategory = arrayOf(Constants.ZAKUSKI,Constants.ZAKUSKI)))

        list.add(Pizza(31, R.raw.img_31,"Две Кока-Колы Zero по суперцене","Две Кока-Колы Zero 0,5 по суперцене",
            10,Constants.COMBO, arrayCategory = arrayOf(Constants.NAPITKI,Constants.NAPITKI)
        ))

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

        list.add(Pizza(id = 44, image = R.raw.img_44, name = "Рулетки с корицей", about = "Сытные сладкие рулетки с корицей",
            price = 22, category = Constants.DESERTI,main = true))

        list.add(Pizza(id = 45, image = R.raw.img_45, name = "Чизкейк Нюь-Йорк", about = "Классические американские творожный десерт",
            price = 23, category = Constants.DESERTI, shtuk = 1))

        list.add(Pizza(id = 46, image = R.raw.img_46, name = "Маффин Три шоколада", about = "Десерт из натурального какао, нежной начинки на основе шоколада и кубиков белого и молочного шоколада",
            price = 12, category = Constants.DESERTI, shtuk =1 ))

        list.add(Pizza(id = 47, image = R.raw.img_47, name = "Кукис Три шоколада", about = "Большое нежное печенье с кусочками бельгийского молочного, тёмного и белого шоколада",
            price = 11, category = Constants.DESERTI, shtuk = 1))

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

        list.add(Pizza(id = 55, image = R.raw.img_55, name = "Сырный соус",
            price = 5, category = Constants.SOUSI, shtuk = 1, main = true))

        list.add(Pizza(id = 56, image = R.raw.img_56, name = "Барбекю",
            price = 5, category = Constants.SOUSI, shtuk = 1))

        list.add(Pizza(id = 57, image = R.raw.img_57, name = "Чесночный",
            price = 5, category = Constants.SOUSI, shtuk = 1))

        list.add(Pizza(id = 58, image = R.raw.img_58, name = "Додо Раскарска",
            price = 2, category = Constants.DRUGIE, shtuk = 1))

        list.add(Pizza(id = 59, image = R.raw.img_59, name = "Додо книги 1+2", about = "Набор из двух книг - \"Додо Книга 1\" и  \"Додо Книга 2\". Рассказываем об истории, ценностях и развитии компании ",
            price = 49, category = Constants.DRUGIE, shtuk = 2))

        return list
    }
}