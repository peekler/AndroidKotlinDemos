package hu.bme.aut.android.kotifydemo.interactor.artists

import android.util.Log
import hu.bme.aut.android.kotifydemo.interactor.artists.event.GetArtistsEvent
import hu.bme.aut.android.kotifydemo.network.ArtistsApi
import hu.bme.aut.android.kotifydemo.network.TokenApi
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class ArtistsInteractor @Inject constructor(private var artistsApi: ArtistsApi, private var tokenApi: TokenApi) {

    fun getArtists(artistQuery: String) {
        val tokenQueryCall = tokenApi.getToken()
        val event = GetArtistsEvent()

        try {
            val token = tokenQueryCall.execute().body()


            val artistsQueryCall = artistsApi.getArtists("Bearer " + token?.token, artistQuery, "artist", 0, 3)

            val response = artistsQueryCall.execute()
            Log.d("Reponse", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.artists = response.body()?.artists?.items
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }
}
