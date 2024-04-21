package com.ubaya.uts160421066.model.response

import com.google.gson.annotations.SerializedName

data class ResponseProfile(

	@field:SerializedName("profile")
	val profile: List<ProfileItem>
)

data class ProfileItem(

	@field:SerializedName("last_name")
	val lastName: String,

	@field:SerializedName("first_name")
	val firstName: String,

	@field:SerializedName("username")
	val username: String
)

data class LoginResponse(val message: String)

