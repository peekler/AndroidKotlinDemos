package hu.bme.aut.android.kotifydemo.model

import com.google.gson.annotations.SerializedName

data class Token(
        @SerializedName("access_token")
        var token: String? = null,
        @SerializedName("token_type")
        var type: String? = null,
        @SerializedName("expires_in")
        var expires: Int? = null
)
