package com.ubaya.uts160421066.view

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.uts160421066.databinding.ActivityMainBinding
import com.ubaya.uts160421066.model.response.HobbiesItem
import com.ubaya.uts160421066.model.response.ResponseHobby
import com.ubaya.uts160421066.model.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        findHobby()
    }

    private fun findHobby() {
        val client = ApiConfig.getApiService().getHobbies()
        client.enqueue(object : Callback<ResponseHobby> {
            override fun onResponse(
                call: Call<ResponseHobby>,
                response: Response<ResponseHobby>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        setHobbyData(responseBody.hobbies)
                    }
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResponseHobby>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }

    private fun setHobbyData(hobbies: List<HobbiesItem>) {
        val adapter = HobbyAdapter()
        adapter.submitList(hobbies)
        binding.rvHobby.adapter = adapter
        binding.rvHobby.layoutManager = LinearLayoutManager(this)
    }

    companion object {
        const val TAG = "MainActivity"
    }
}