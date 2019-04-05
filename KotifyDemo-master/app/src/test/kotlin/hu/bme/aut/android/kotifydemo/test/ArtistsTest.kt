package hu.bme.aut.android.kotifydemo.test

import hu.bme.aut.android.kotifydemo.model.Item
import hu.bme.aut.android.kotifydemo.testInjector
import hu.bme.aut.android.kotifydemo.ui.artists.ArtistsPresenter
import hu.bme.aut.android.kotifydemo.ui.artists.ArtistsScreen
import hu.bme.aut.android.kotifydemo.utils.argumentCaptor
import hu.bme.aut.android.kotifydemo.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class ArtistsTest {
    @Inject
    lateinit var artistsPresenter: ArtistsPresenter

    private lateinit var artistsScreen: ArtistsScreen
    private lateinit var query: String

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        artistsScreen = mock()
        artistsPresenter.attachScreen(artistsScreen)
    }

    @Test
    fun testArtists() {
        query = "AC/DC"
        artistsPresenter.refreshArtists(query)

        val list = argumentCaptor<MutableList<Item>>()
        verify(artistsScreen).showArtists(list.capture())
        assert(list.value.size > 0)
    }

    @After
    fun tearDown() {
        artistsPresenter.detachScreen()
    }
}