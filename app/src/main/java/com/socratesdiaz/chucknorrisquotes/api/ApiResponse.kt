package com.socratesdiaz.chucknorrisquotes.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.json.JSONObject


/**
 * Created by socratesdiaz on 10/5/17.
 */
class ApiResponse<T> {
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("value")
    @Expose
    var value: T? = null
}