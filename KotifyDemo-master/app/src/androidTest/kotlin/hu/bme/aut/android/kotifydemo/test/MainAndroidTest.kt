package hu.bme.aut.android.kotifydemo.test

import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.runner.AndroidJUnit4
import hu.bme.aut.android.kotifydemo.R
import hu.bme.aut.android.kotifydemo.ui.main.MainActivity
import hu.bme.aut.android.kotifydemo.utils.AndroidTestUtils.setTestInjector
import hu.bme.aut.android.kotifydemo.utils.EspressoTest
import hu.bme.aut.android.kotifydemo.utils.matchToolbarTitle
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainAndroidTest : EspressoTest<MainActivity>(MainActivity::class.java) {

    @Before
    fun setUp() {
        setTestInjector()
        activityRule.launchActivity(Intent())
    }

    @Test
    fun testNavigateToArtistActivity() {
        onView(withId(R.id.etArtist)).perform(typeText(ARTIST), closeSoftKeyboard())
        onView(withId(R.id.btnShowArtists)).perform(click())
        matchToolbarTitle(ARTIST_ACTIVITY_TITLE)
    }

    companion object {
        private const val ARTIST = "AC/DC"
        private const val ARTIST_ACTIVITY_TITLE = "ArtistsActivity"
    }


}