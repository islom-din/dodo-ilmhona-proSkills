package islom.din.dodo_ilmhona_proskills.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import islom.din.dodo_ilmhona_proskills.ComboFragment
import islom.din.dodo_ilmhona_proskills.FragmetSelectPizza
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.databinding.ActivityMainBinding
import islom.din.dodo_ilmhona_proskills.view.ViewPager.FragmentViewPager

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout,ComboFragment.newInstance(), "comboFragment")
            .addToBackStack("comboFragment")
            .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}

