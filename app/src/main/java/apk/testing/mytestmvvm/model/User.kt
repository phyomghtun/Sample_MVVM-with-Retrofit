package apk.testing.mytestmvvm.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("phone")
    val phone: String
)