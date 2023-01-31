package islom.din.dodo_ilmhona_proskills.shodmon.khushbakht.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.shodmon.khushbakht.viewmodel.VpAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentAdapter: VpAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentAdapter = VpAdapter(listOf(

        ), this)
    }
}