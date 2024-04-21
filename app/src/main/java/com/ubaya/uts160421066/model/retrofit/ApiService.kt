package com.ubaya.uts160421066.model.retrofit

import com.ubaya.uts160421066.model.response.LoginResponse
import com.ubaya.uts160421066.model.response.ResponseHobby
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("hobby")
    fun getHobbies(): Call<ResponseHobby>

    @FormUrlEncoded
    @POST("login")
    fun loginUser(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginResponse>
}