package android.maxim.retrofitpracticeusername.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("users/{id}")
    fun getUserData(@Path("id") id: Int): Call<UserResponse>
}