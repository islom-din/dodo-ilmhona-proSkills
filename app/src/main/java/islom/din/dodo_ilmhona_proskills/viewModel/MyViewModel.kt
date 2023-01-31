package islom.din.dodo_ilmhona_proskills.viewModel

import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.model.Sous

class MyViewModel {
    fun getListCous(): List<Sous> {
        val list = mutableListOf<Sous>(
            Sous(1, R.drawable.sirniy_bortikpng, "Сырный бортик", 25),
            Sous(1, R.drawable.brinzapng, "sousoso", 25),
            Sous(1, R.drawable.siplyonok, "sousoso", 25),
            Sous(1, R.drawable.govyadinapng, "sousoso", 25),
            Sous(1, R.drawable.krasniy_lukpng, "sousoso", 25),
            Sous(1, R.drawable.maslinipng, "sousoso", 25),
            Sous(1, R.drawable.ogursipng, "sousoso", 25),
            Sous(1, R.drawable.pipperonipng, "sousoso", 25),
            Sous(1, R.drawable.perecpng, "sousoso", 25),
            Sous(1, R.drawable.travipng, "sousoso", 25)
        )
        return list
    }

    fun getListCous1(): List<Sous> {
        val list = mutableListOf<Sous>(
        Sous(1, R.drawable.govyadinapng, "sousoso", 18),
        Sous(1, R.drawable.govyadinapng, "sousoso", 18),
        Sous(1, R.drawable.govyadinapng, "sousoso", 18),
        Sous(1, R.drawable.govyadinapng, "sousoso", 18),
        Sous(1, R.drawable.govyadinapng, "sousoso", 18),
        Sous(1, R.drawable.govyadinapng, "sousoso", 18),
        Sous(1, R.drawable.govyadinapng, "sousoso", 18),
        Sous(1, R.drawable.govyadinapng, "sousoso", 18),

        )
        return list
    }

    fun getListCous2(): List<Sous> {
        val list = mutableListOf<Sous>(
            Sous(1, R.drawable.halapenopng, "sousoso", 10),
            Sous(1, R.drawable.halapenopng, "sousoso", 10),
            Sous(1, R.drawable.halapenopng, "sousoso", 10),
            Sous(1, R.drawable.halapenopng, "sousoso", 10),
            Sous(1, R.drawable.halapenopng, "sousoso", 10),
            Sous(1, R.drawable.halapenopng, "sousoso", 10),
            Sous(1, R.drawable.halapenopng, "sousoso", 10),
            Sous(1, R.drawable.halapenopng, "sousoso", 10),

            )
        return list
    }
}