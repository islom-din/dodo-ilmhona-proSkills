package islom.din.dodo_ilmhona_proskills.repository

import islom.din.dodo_ilmhona_proskills.Constants
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.data.Vkus

class GetVkusList {
    fun getList() : List<Vkus> {
        val list = mutableListOf<Vkus>()

        list.add(Vkus(id = 1,R.raw.ingridient_1,"Брынза", mapOf(Constants.MALENKAYA to 8,Constants.SREDNAYA to 10, Constants.BOLSHAYA to 13)))
        list.add(Vkus(id = 2,R.raw.ingridient_2,"Ветчина  из цыплёнка", mapOf(Constants.MALENKAYA to 7,Constants.SREDNAYA to 10, Constants.BOLSHAYA to 13)))
        list.add(Vkus(id = 3,R.raw.ingridient_3,"Говядина", mapOf(Constants.MALENKAYA to 8,Constants.SREDNAYA to 10, Constants.BOLSHAYA to 13)))
        list.add(Vkus(id = 4,R.raw.ingridient_4,"Красный лук", mapOf(Constants.MALENKAYA to 5,Constants.SREDNAYA to 7, Constants.BOLSHAYA to 9)))
        list.add(Vkus(id = 5,R.raw.ingridient_5,"Маслины", mapOf(Constants.MALENKAYA to 8,Constants.SREDNAYA to 10, Constants.BOLSHAYA to 13)))
        list.add(Vkus(id = 6,R.raw.ingridient_6,"Солёные огурчики", mapOf(Constants.MALENKAYA to 5,Constants.SREDNAYA to 7, Constants.BOLSHAYA to 9)))
        list.add(Vkus(id = 7,R.raw.ingridient_7,"Пикартная пепперони", mapOf(Constants.MALENKAYA to 7,Constants.SREDNAYA to 10, Constants.BOLSHAYA to 13 )))
        list.add(Vkus(id = 8,R.raw.ingridient_8,"Сладкий перец", mapOf(Constants.MALENKAYA to 5,Constants.SREDNAYA to 7, Constants.BOLSHAYA to 9)))
        list.add(Vkus(id = 9,R.raw.ingridient_9,"Итальянские травы", mapOf(Constants.MALENKAYA to 5,Constants.SREDNAYA to 7, Constants.BOLSHAYA to 9)))
        list.add(Vkus(id = 10,R.raw.ingridient_10,"Острая чоризо", mapOf(Constants.MALENKAYA to 8,Constants.SREDNAYA to 10, Constants.BOLSHAYA to 13)))
        list.add(Vkus(id = 11,R.raw.ingridient_11,"Смесь сыров Чеддер и Пармезан", mapOf(Constants.MALENKAYA to 8,Constants.SREDNAYA to 10, Constants.BOLSHAYA to 13)))
        list.add(Vkus(id = 12,R.raw.ingridient_12,"Cыр блю чиз", mapOf(Constants.MALENKAYA to 9,Constants.SREDNAYA to 11, Constants.BOLSHAYA to 13)))
        list.add(Vkus(id = 13,R.raw.ingridient_13,"Сырный бортик", mapOf(Constants.MALENKAYA to 18,Constants.SREDNAYA to 22, Constants.BOLSHAYA to 25)))
        list.add(Vkus(id = 13,R.raw.ingridient_13,"Сырный бортик", mapOf(Constants.MALENKAYA to 18,Constants.SREDNAYA to 22, Constants.BOLSHAYA to 25)))
        list.add(Vkus(id = 14,R.raw.ingridient_14,"Томаты", mapOf(Constants.MALENKAYA to 5,Constants.SREDNAYA to 8, Constants.BOLSHAYA to 10)))
        list.add(Vkus(id = 15,R.raw.ingridient_15,"Острый халапеньо", mapOf(Constants.MALENKAYA to 5,Constants.SREDNAYA to 7, Constants.BOLSHAYA to 8)))
        list.add(Vkus(id = 16,R.raw.ingridient_16,"Цыплёнок", mapOf(Constants.MALENKAYA to 8,Constants.SREDNAYA to 10, Constants.BOLSHAYA to 13)))
        list.add(Vkus(id = 17,R.raw.ingridient_17,"Шампиньоны", mapOf(Constants.MALENKAYA to 8,Constants.SREDNAYA to 10, Constants.BOLSHAYA to 13)))
        list.add(Vkus(id = 18,R.raw.ingridient_18,"Сыр моцарелла", mapOf(Constants.MALENKAYA to 8,Constants.SREDNAYA to 10, Constants.BOLSHAYA to 13)))


        return list
    }
}