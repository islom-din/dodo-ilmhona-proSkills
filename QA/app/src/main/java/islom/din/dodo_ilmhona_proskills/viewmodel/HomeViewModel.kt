package islom.din.dodo_ilmhona_proskills.viewmodel

import androidx.lifecycle.ViewModel
import islom.din.dodo_ilmhona_proskills.data.Category
import islom.din.dodo_ilmhona_proskills.repository.GetCategoryList
import islom.din.dodo_ilmhona_proskills.repository.GetPizzaList

class HomeViewModel : ViewModel() {

    //Getting category list from repository permanently  for category recycler view in home fragment
    var categoryList: List<Category> = GetCategoryList().getCategory()

    // Getting pizza list from repository for pizza recycler view in home fragment
    var pizzaList = GetPizzaList().getList()

}