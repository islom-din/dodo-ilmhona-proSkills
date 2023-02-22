package islom.din.dodo_ilmhona_proskills.application

import android.app.Application
import islom.din.dodo_ilmhona_proskills.dbMain.DataBaseMain

class DataBaseApplication : Application() {
    val database : DataBaseMain by lazy {
        DataBaseMain.getInstance(this)
    }
}