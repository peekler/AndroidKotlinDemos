package hu.bme.aut.android.kotifydemo

import android.app.Activity
import android.support.v4.app.Fragment


val Activity.injector: KotifyDemoApplicationComponent
    get() {
        return (this.applicationContext as KotifyDemoApplication).injector
    }

val Fragment.injector: KotifyDemoApplicationComponent
    get() {
        return (this.context!!.applicationContext as KotifyDemoApplication).injector
    }

