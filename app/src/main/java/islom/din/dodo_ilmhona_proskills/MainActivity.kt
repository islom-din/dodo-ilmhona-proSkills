package islom.din.dodo_ilmhona_proskills

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import islom.din.dodo_ilmhona_proskills.databinding.ActivityMainBinding
import islom.din.dodo_ilmhona_proskills.db.DataBase
import islom.din.dodo_ilmhona_proskills.db.MPizza
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    //Binding this layout
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Navigation view getting from layout
        val bottomNavView = binding.bottomNavView

        // Getting my Nav Host and setting to it a Nav Controller
        val navFragment =
            supportFragmentManager.findFragmentById(binding.fragmentsContainer.id) as NavHostFragment
        val navController = navFragment.navController

        Log.d("example_tag", "Step 3")
        //Implementing navigation beetween fragments clicking Bottom NavView
        bottomNavView.setupWithNavController(navController)
        bottomNavView.itemIconTintList = null

    }

}