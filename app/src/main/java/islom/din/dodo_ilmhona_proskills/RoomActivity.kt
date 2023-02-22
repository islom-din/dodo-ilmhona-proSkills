package islom.din.dodo_ilmhona_proskills

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import islom.din.dodo_ilmhona_proskills.databinding.ActivityRoomBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RoomActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val pizza = listOf<MPizza>(MPizza(1,"DoDo",23),(MPizza(2,"DoDfdso",345)),(MPizza(3,"dsaf",23)))
//        val adapter = RoomAdapter()
//        adapter.submitList(pizza)
//        binding.rv.adapter = adapter
//        CoroutineScope(Dispatchers.IO).launch {
//            val dataBase = DataBase.getInstance(this@RoomActivity)
//            val allPizza = dataBase.pizzaDao().getAllPizza()
//            Log.d("TAG","$allPizza")
//            withContext(Dispatchers.Main) {
//                    val adapter = RoomAdapter()
//                    adapter.submitList(allPizza)
//                    binding.rv.adapter = adapter
//            }
//        }
    }
}