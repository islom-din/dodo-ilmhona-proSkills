package islom.din.dodo_ilmhona_proskills.paging

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import islom.din.dodo_ilmhona_proskills.QA.data.Pizza
import islom.din.dodo_ilmhona_proskills.khq.dbMain.Products
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val  BASE_URL = "http://192.168.0.106:8080/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface PizzaApiService {
    @GET("pizzas")
    suspend fun getData() : List<Products>
}

object PizzaApi {
    val retrofitService : PizzaApiService by lazy {
        retrofit.create(PizzaApiService::class.java)
    }
}