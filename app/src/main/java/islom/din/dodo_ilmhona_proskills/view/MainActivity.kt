package islom.din.dodo_ilmhona_proskills.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import islom.din.dodo_ilmhona_proskills.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val navFragment =
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment)  as NavHostFragment
    val navController = navFragment.navController
}
}