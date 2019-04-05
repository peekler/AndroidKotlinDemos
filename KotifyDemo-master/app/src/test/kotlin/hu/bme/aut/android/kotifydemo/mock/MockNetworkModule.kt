package hu.bme.aut.android.kotifydemo.mock


import dagger.Module
import dagger.Provides
import hu.bme.aut.android.kotifydemo.network.ArtistsApi
import hu.bme.aut.android.kotifydemo.network.TokenApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
class MockNetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun provideArtistsApi(): ArtistsApi = MockArtistApi()

    @Provides
    @Singleton
    fun provideTokenApi(): TokenApi = MockTokenApi()
}
