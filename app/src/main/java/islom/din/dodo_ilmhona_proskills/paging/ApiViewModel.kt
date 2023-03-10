package islom.din.dodo_ilmhona_proskills.paging

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import islom.din.dodo_ilmhona_proskills.khq.dbMain.Products
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ApiViewModel : ViewModel() {
    private val _dataResult = MutableLiveData<List<Products>>()
    val dataResult : LiveData<List<Products>> get() = _dataResult

    private var _status = MutableLiveData<Boolean>()
    val status : LiveData<Boolean> get() = _status

    fun getData(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _dataResult.postValue(PizzaApi.retrofitService.getData())

                _status.postValue(true)
            }catch (e : Exception){
                Log.d("MYERROR","$e")
                _status.postValue(false)
            }

        }
    }

    init {
        getData()
    }
}