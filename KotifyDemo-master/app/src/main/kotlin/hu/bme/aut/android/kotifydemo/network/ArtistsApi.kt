package hu.bme.aut.android.kotifydemo.network

import hu.bme.aut.android.kotifydemo.model.ArtistsResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ArtistsApi {
    @GET("search")
    fun getArtists(
            @Header("Authorization") authorisation: String,
            @Query("query") artist: String,
            @Query("type") type: String,
            @Query("offset") offset: Int,
            @Query("limit") limit: Int): Call<ArtistsResult>
}
