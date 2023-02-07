package islom.din.dodo_ilmhona_proskills.QA.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import islom.din.dodo_ilmhona_proskills.QA.Constants
import islom.din.dodo_ilmhona_proskills.QA.data.Pizza
import islom.din.dodo_ilmhona_proskills.QA.repository.GetPizzaList
import kotlin.random.Random

class HomeViewModel : ViewModel() {

    //Getting category list from repository permanently  for category recycler view in home fragment
//    var categoryList: List<Category> = GetCategoryList().getCategory()

    // Getting pizza list from repository for pizza recycler view in home fragment
    var pizzaList = GetPizzaList().getList()

    var hideBottomNavView = true

    private var _orderType = MutableLiveData(Constants.DOSTAVKA)
    val orderStreet : LiveData<String> get() = _orderType

    fun changeOrderType(type : String){
        _orderType.value = type
    }

    fun interestingList() : List<Pizza> {
        val newList = mutableListOf<Pizza>()

        for (pizza in 0..9) {
            var randomPizza = Random.nextInt(0,pizzaList.size)
            newList.add(pizzaList[randomPizza])
        }

        return newList
    }

    val categoryList =
        arrayListOf(
            Constants.PIZZA,
            Constants.COMBO,
            Constants.ZAKUSKI,
            Constants.DESERTI,
            Constants.NAPITKI,
            Constants.SOUSI,
            Constants.DRUGIE)
}