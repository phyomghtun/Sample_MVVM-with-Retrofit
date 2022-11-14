package apk.testing.mytestmvvm.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiInstance {
    val BASE_URL = "https://phyomghtun.github.io"

    val api: ApiInterface by lazy{
         Retrofit.Builder()
             .baseUrl(BASE_URL)
             .addConverterFactory(GsonConverterFactory.create())
             .build()
             .create(ApiInterface::class.java)
    }
}