package work.beltran.kotlinandroidmvp.api

import com.google.gson.annotations.SerializedName

data class Repo(val name: String,
                val description: String,
                @SerializedName("html_url")
                val htmlUrl: String)
