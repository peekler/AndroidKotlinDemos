package hu.bme.aut.android.kotifydemo.model

import com.google.gson.annotations.SerializedName

data class ExternalUrls(
        @SerializedName("spotify")
        var spotify: String? = null
)