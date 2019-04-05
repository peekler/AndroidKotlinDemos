package hu.bme.aut.android.kotifydemo.model

import com.google.gson.annotations.SerializedName

data class Item(
        @SerializedName("external_urls")
        var externalUrls: ExternalUrls? = null,
        @SerializedName("followers")
        var followers: Followers? = null,
        @SerializedName("genres")
        var genres: MutableList<String>? = null,
        @SerializedName("href")
        var href: String? = null,
        @SerializedName("id")
        var id: String? = null,
        @SerializedName("images")
        var images: MutableList<Image>? = null,
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("popularity")
        var popularity: Int? = null,
        @SerializedName("type")
        var type: String? = null,
        @SerializedName("uri")
        var uri: String? = null
)
