package hu.bme.aut.android.kotifydemo.network

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }


    @Provides
    @Singleton
    fun provideTokenApi(client: OkHttpClient): TokenApi {
        val retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl(NetworkConfig.TOKEN_ENDPOINT_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(TokenApi::class.java)
    }

    @Provides
    @Singleton
    fun provideArtistsApi(client: OkHttpClient): ArtistsApi {
        val retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl(NetworkConfig.API_ENDPOINT_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(ArtistsApi::class.java)
    }
}
