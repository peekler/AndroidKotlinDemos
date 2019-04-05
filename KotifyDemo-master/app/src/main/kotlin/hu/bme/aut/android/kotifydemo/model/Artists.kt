package hu.bme.aut.android.kotifydemo.model

import com.google.gson.annotations.SerializedName

data class Artists(
        @SerializedName("href")
        var href: String? = null,
        @SerializedName("items")
        var items: List<Item>? = null,
        @SerializedName("limit")
        var limit: Int? = null,
        @SerializedName("next")
        var next: String? = null,
        @SerializedName("offset")
        var offset: Int? = null,
        @SerializedName("previous")
        var previous: Any? = null,
        @SerializedName("total")
        var total: Int? = null
)
