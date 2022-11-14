package apk.testing.mytestmvvm.network

import apk.testing.mytestmvvm.model.User
import apk.testing.mytestmvvm.model.UserData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/wt5k_lk/user.json")
    fun getUser(): Call<UserData>
}