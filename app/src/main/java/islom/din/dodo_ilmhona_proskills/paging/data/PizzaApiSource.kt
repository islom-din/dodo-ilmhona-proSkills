package islom.din.dodo_ilmhona_proskills.paging.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import islom.din.dodo_ilmhona_proskills.khq.dbMain.Products
import islom.din.dodo_ilmhona_proskills.paging.PizzaApi
import kotlinx.coroutines.delay
import retrofit2.HttpException
import retrofit2.Response

class PizzaApiSource(
    private val PizzaApi : PizzaApi,
) : PagingSource<Int,Products>() {
    override fun getRefreshKey(state: PagingState<Int, Products>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Products> {

        val page : Int = params.key ?: 1
        val pageSize : Int = params.loadSize.coerceAtMost(10)

        if (page != 1) delay(1500)

        val response: Response<List<Products>> = PizzaApi.retrofitService.getData(page,pageSize)
        if (response.isSuccessful){
            val pizzas = response.body()
            val nextKey = if (pizzas?.size!! < pageSize) null else page + 1
            val prevKey = if (page == 1) null else page - 1
            return LoadResult.Page(pizzas,prevKey,nextKey)
        }else {
            return LoadResult.Error(HttpException(response))
        }
    }
}