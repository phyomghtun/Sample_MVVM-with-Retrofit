package apk.testing.mytestmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import apk.testing.mytestmvvm.adapter.UserRvAdapter
import apk.testing.mytestmvvm.databinding.ActivityMainBinding
import apk.testing.mytestmvvm.model.User
import apk.testing.mytestmvvm.model.UserData
import apk.testing.mytestmvvm.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel
    private lateinit var userRvAdapter: UserRvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        initialize()
    }

    private fun initialize(){
        userRvAdapter = UserRvAdapter()
        activityMainBinding.rView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = userRvAdapter
        }
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        userViewModel.getUserList()
        userViewModel.userLiveData.observe(this){ userData ->
            userRvAdapter.setUserList(userData.user)
        }
    }

}