package apk.testing.mytestmvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import apk.testing.mytestmvvm.model.User
import apk.testing.mytestmvvm.model.UserData
import apk.testing.mytestmvvm.network.ApiInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel() {
    private val _userLiveData = MutableLiveData<UserData>()
    val userLiveData : LiveData<UserData> = _userLiveData

    fun getUserList(){
         ApiInstance.api.getUser().enqueue(object: Callback<UserData> {
             override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                 if(response.body()!=null){
                     _userLiveData.value = response.body()
//                     Log.d("success_msg",response.body().toString())
                 }
             }

             override fun onFailure(call: Call<UserData>, t: Throwable) {
                 Log.e("error_msg",t.toString())
             }

         })
    }

}