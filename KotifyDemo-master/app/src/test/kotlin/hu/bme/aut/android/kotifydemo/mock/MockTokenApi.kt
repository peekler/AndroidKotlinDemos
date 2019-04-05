package hu.bme.aut.android.kotifydemo.mock

import hu.bme.aut.android.kotifydemo.model.Token
import hu.bme.aut.android.kotifydemo.network.TokenApi
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MockTokenApi : TokenApi {

    override fun getToken(granType: String, type: String): Call<Token> {
        val token = Token()
        token.token = "ABCD"
        token.expires = 6000
        token.type = "mock"

        val call = object : Call<Token> {
            override fun enqueue(callback: Callback<Token>?) {
            }

            @Throws(IOException::class)
            override fun execute(): Response<Token> {
                return Response.success(token)
            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<Token> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }

        return call
    }


}
