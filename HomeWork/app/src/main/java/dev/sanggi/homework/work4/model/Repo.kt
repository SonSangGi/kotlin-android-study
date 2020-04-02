package dev.sanggi.homework.work4.model

import com.google.gson.annotations.SerializedName

data class Repo(
    var id: Int,
    var name: String,
    var owner: Owner,
    @SerializedName("html_url")
    var url: String,
    @SerializedName("full_name")
    var fullName: String,
    @SerializedName("updated_at")
    var updatedAt: String
)

data class Owner(
    var login: String? = null,
    var url: String? = null,
    @SerializedName("avatar_url")
    var avatarUrl: String? = null
)