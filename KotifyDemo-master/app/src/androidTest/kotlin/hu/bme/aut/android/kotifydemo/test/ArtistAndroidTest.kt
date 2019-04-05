package hu.bme.aut.android.kotifydemo.test

import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.AndroidJUnit4
import hu.bme.aut.android.kotifydemo.ui.artists.ArtistsActivity
import hu.bme.aut.android.kotifydemo.ui.main.MainActivity
import hu.bme.aut.android.kotifydemo.utils.AndroidTestUtils.setTestInjector
import hu.bme.aut.android.kotifydemo.utils.ElapsedTimeIdlingResource.Companion.waitFor
import hu.bme.aut.android.kotifydemo.utils.EspressoTest
import org.hamcrest.Matchers.allOf
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ArtistAndroidTest : EspressoTest<ArtistsActivity>(ArtistsActivity::class.java) {

    @Before fun setUp() {
        setTestInjector()
        activityRule.launchActivity(Intent().putExtra(MainActivity.KEY_ARTIST, ARTIST))
    }

    @Test fun testSearch() {
        onView(withId(hu.bme.aut.android.kotifydemo.R.id.etArtist)).check(matches(withText(ARTIST)))
        waitFor(2000) {
            onView(allOf(withId(hu.bme.aut.android.kotifydemo.R.id.tvName), withText(ARTIST))).check(matches(isDisplayed()))
        }
    }

    companion object {
        private const val ARTIST = "AC/DC"
    }


}