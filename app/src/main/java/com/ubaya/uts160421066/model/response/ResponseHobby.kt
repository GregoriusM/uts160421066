package com.ubaya.uts160421066.model.response

import com.google.gson.annotations.SerializedName

data class ResponseHobby(

	@field:SerializedName("hobbies")
	val hobbies: List<HobbiesItem>
)

data class HobbiesItem(

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("detail_description")
	val detailDescription: String,

	@field:SerializedName("date")
	val date: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("username")
	val username: String
)
