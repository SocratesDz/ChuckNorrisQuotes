package com.socratesdiaz.chucknorrisquotes.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by socratesdiaz on 10/5/17.
 */
class Joke {
    @SerializedName("id")
    @Expose
    val id: Int? = null
    @SerializedName("joke")
    @Expose
    val content: String? = null
    @SerializedName("categories")
    @Expose
    val categories: List<String>? = null
}