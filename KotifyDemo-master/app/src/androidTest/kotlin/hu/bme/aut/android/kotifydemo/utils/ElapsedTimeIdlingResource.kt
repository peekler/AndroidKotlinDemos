package hu.bme.aut.android.kotifydemo.utils

import android.support.test.espresso.Espresso
import android.support.test.espresso.IdlingResource

@Suppress("DEPRECATION")
class ElapsedTimeIdlingResource(private val waitingTime: Long) : IdlingResource {
    private val startTime: Long
    private var resourceCallback: IdlingResource.ResourceCallback? = null

    init {
        this.startTime = System.currentTimeMillis()
    }

    override fun getName(): String {
        return ElapsedTimeIdlingResource::class.java.name + ":" + waitingTime
    }

    override fun isIdleNow(): Boolean {
        val elapsed = System.currentTimeMillis() - startTime
        val idle = elapsed >= waitingTime
        if (idle) {
            resourceCallback!!.onTransitionToIdle()
        }
        return idle
    }

    override fun registerIdleTransitionCallback(resourceCallback: IdlingResource.ResourceCallback) {
        this.resourceCallback = resourceCallback
    }


    interface Listener {
        fun inIdle()
    }

    companion object {

        fun waitFor(time: Long = 500, body: () -> Unit) {
            val idlingResource = ElapsedTimeIdlingResource(time)
            Espresso.registerIdlingResources(idlingResource)
            body.invoke()
            Espresso.unregisterIdlingResources(idlingResource)
        }


    }
}