package hu.bme.aut.android.kotifydemo.network

import hu.bme.aut.android.kotifydemo.model.Token
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface TokenApi {
    @POST("token")
    @FormUrlEncoded
    fun getToken(@Field("grant_type") granType: String = "client_credentials",
                 @Header("Authorization") type: String = "Basic MDM0MjY2ODU0OTI1NGZkOWFiMzdmMzNlZjRkNjRkYjA6ODM1MWFiMjVjYzVmNDBhMjg5OGI5N2U5ZjQyMmNkMDk="): Call<Token>
}
