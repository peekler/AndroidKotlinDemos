package hu.bme.aut.android.kotifydemo.mock

import hu.bme.aut.android.kotifydemo.model.Artists
import hu.bme.aut.android.kotifydemo.model.ArtistsResult
import hu.bme.aut.android.kotifydemo.model.Image
import hu.bme.aut.android.kotifydemo.model.Item
import hu.bme.aut.android.kotifydemo.network.ArtistsApi
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Query
import java.io.IOException
import java.util.*

class MockArtistApi : ArtistsApi {
    override fun getArtists(authorisation: String, @Query("query") artist: String, @Query("type") type: String, @Query("offset") offset: Int, @Query("limit") limit: Int): Call<ArtistsResult> {
        val artistsResult = ArtistsResult()
        val artists = Artists()

        val items = ArrayList<Item>()

        val item = Item()
        item.name = "AC/DC"
        item.popularity = 99

        val images = ArrayList<Image>()
        val image = Image()
        image.url = "https://i.scdn.co/image/a16c5d95ede008ec905d6ca6d1b5abbf39ad4566"
        image.width = 1000
        image.height = 1500
        images.add(image)

        item.images = images
        items.add(item)

        artists.items = items
        artistsResult.artists = artists

        val call = object : Call<ArtistsResult> {
            @Throws(IOException::class)
            override fun execute(): Response<ArtistsResult> {
                return Response.success(artistsResult)
            }

            override fun enqueue(callback: Callback<ArtistsResult>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<ArtistsResult> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }

        return call
    }


}
