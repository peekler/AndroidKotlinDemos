package hu.bme.aut.android.kotifydemo.model

import com.google.gson.annotations.SerializedName

data class ArtistsResult(
        @SerializedName("artists")
        var artists: Artists? = null
)
