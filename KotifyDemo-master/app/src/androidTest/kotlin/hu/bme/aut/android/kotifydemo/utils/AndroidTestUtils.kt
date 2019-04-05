package hu.bme.aut.android.kotifydemo.utils

import android.support.test.InstrumentationRegistry
import hu.bme.aut.android.kotifydemo.AndroidTestModule
import hu.bme.aut.android.kotifydemo.DaggerAndroidTestComponent
import hu.bme.aut.android.kotifydemo.DaggerKotifyDemoApplicationComponent
import hu.bme.aut.android.kotifydemo.KotifyDemoApplication
import hu.bme.aut.android.kotifydemo.ui.UIModule

object AndroidTestUtils {

    fun setTestInjector() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val app = instrumentation.targetContext.applicationContext as KotifyDemoApplication

        val androidTestComponent = DaggerAndroidTestComponent.builder().androidTestModule(AndroidTestModule(app)).build()
        app.injector = androidTestComponent
    }

    fun setProdutionInjector() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val app = instrumentation.targetContext.applicationContext as KotifyDemoApplication

        val androidTestComponent = DaggerKotifyDemoApplicationComponent.builder().uIModule(UIModule(app)).build()
        app.injector = androidTestComponent
    }
}
