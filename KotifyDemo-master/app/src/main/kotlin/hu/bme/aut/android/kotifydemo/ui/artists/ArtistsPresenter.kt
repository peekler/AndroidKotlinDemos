package hu.bme.aut.android.kotifydemo.ui.artists

import hu.bme.aut.android.kotifydemo.interactor.artists.ArtistsInteractor
import hu.bme.aut.android.kotifydemo.interactor.artists.event.GetArtistsEvent
import hu.bme.aut.android.kotifydemo.model.Item
import hu.bme.aut.android.kotifydemo.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class ArtistsPresenter @Inject constructor(private val executor: Executor, private val artistsInteractor: ArtistsInteractor) : Presenter<ArtistsScreen>() {

    override fun attachScreen(screen: ArtistsScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun refreshArtists(artistQuery: String) {
        executor.execute {
            artistsInteractor.getArtists(artistQuery)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetArtistsEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.artists != null) {
                    screen?.showArtists(event.artists as MutableList<Item>)
                }

            }
        }
    }
}
