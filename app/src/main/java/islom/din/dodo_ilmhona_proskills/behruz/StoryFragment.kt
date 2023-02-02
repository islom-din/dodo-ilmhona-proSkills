package islom.din.dodo_ilmhona_proskills.behruz

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import islom.din.dodo_ilmhona_proskills.databinding.FragmentStoryBinding
import islom.din.dodo_ilmhona_proskills.shodmon.khushbakht.viewmodel.VpAdapter


class StoryFragment : Fragment() {
    private lateinit var binding: FragmentStoryBinding
    private lateinit var vpAdapter : VpAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //TODO:
        // 1) Create adapter instance and set it to viewPages's adapter
        // 2) Start progress view line

        binding.viewPager.adapter = VpAdapter(listOf(), requireActivity())

        
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        //Warning!!! DO NOT DO THIS
        //binding.root
    }

}


//class MyActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
//        super.onCreate(savedInstanceState, persistentState)
//        //view создано
//    }
//
//    override fun onStart() {
//        super.onStart()
//        // view видимо, но пользователь не может взаимодействовать с ней
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        // view видимо и пользователь может взаимодействовать
//    }
//
//    override fun onPause() {
//        super.onPause()
//        // view видимо но пользователь НЕ может взаимодействовать
//    }
//
//    override fun onStop() {
//        super.onStop()
//        // view не видно и пользователь НЕ может взаимодействовать
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        // view уничтожено
//    }
//}