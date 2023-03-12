package islom.din.dodo_ilmhona_proskills.paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import islom.din.dodo_ilmhona_proskills.khq.dbMain.Products
import islom.din.dodo_ilmhona_proskills.paging.data.PizzaApiSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ApiViewModel() : ViewModel() {

    private val _dataResult = MutableLiveData<List<Products>>()
    val dataResult : LiveData<List<Products>> get() = _dataResult

    private var _status = MutableLiveData<Boolean>()
    val status : LiveData<Boolean> get() = _status

    fun getAllPizzas() : Flow<PagingData<Products>> {
        val myPagingSourceFactory = { PizzaApiSource(PizzaApi) }
        return Pager(
            config =  PagingConfig(pageSize = 5),
            pagingSourceFactory = myPagingSourceFactory
        )
            .flow
            .cachedIn(viewModelScope)
    }

    fun getData(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _dataResult.postValue(PizzaApi.retrofitService.getData().body())
                _status.postValue(true)
            }catch (e : Exception){
                _status.postValue(false)
            }
        }
    }
    init {
        getData()
    }
}