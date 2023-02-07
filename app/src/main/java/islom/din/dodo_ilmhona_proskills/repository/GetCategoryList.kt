package islom.din.dodo_ilmhona_proskills.repository

import islom.din.dodo_ilmhona_proskills.data.Category
import islom.din.dodo_ilmhona_proskills.view.Constants

// -------- NOT USED ------------ //
// ------------------------------//


class GetCategoryList {

    //List of categories
    fun getCategory(): List<Category> {
        val list = mutableListOf<Category>()

        list.add(Category(Constants.PIZZA,))
        list.add(Category(Constants.COMBO))
        list.add(Category(Constants.ZAKUSKI))
        list.add(Category(Constants.DESERTI))
        list.add(Category(Constants.NAPITKI))
        list.add(Category(Constants.SOUSI))
        list.add(Category(Constants.DRUGIE))

        return list
    }
}