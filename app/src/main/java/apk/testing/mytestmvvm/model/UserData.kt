package apk.testing.mytestmvvm.model

import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("user")
    val user: List<User>
)