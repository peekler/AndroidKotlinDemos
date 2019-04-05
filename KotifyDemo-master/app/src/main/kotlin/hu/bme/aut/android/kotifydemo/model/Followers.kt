package hu.bme.aut.android.kotifydemo.model

import com.google.gson.annotations.SerializedName

data class Followers(
        @SerializedName("href")
        var href: Any? = null,
        @SerializedName("total")
        var total: Int? = null
)
