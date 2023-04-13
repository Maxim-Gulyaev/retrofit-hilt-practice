package android.maxim.retrofitpracticeusername.ui

import android.maxim.retrofitpracticeusername.model.APIService
import android.maxim.retrofitpracticeusername.model.Repository
import android.maxim.retrofitpracticeusername.model.UserResponse
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject  constructor(val repository: Repository): ViewModel() {

    @Inject
    lateinit var retrofit: Retrofit

    @Inject
    lateinit var liveDataFirstName: MutableLiveData<String>

    fun getUserData(id: Int) {

        val service = retrofit.create(APIService::class.java)
        val call = service.getUserData(id)

        call.enqueue(object: Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.code() == 200) {
                    val userResponse = response.body()!!
                    liveDataFirstName.value = userResponse.firstName!!
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                liveDataFirstName.value = t.message
            }
        })
    }

    fun getFirstName(): MutableLiveData<String> {
        return liveDataFirstName
    }
}