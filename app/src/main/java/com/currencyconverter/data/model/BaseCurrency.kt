package com.currencyconverter.data.model

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class BaseCurrency(

    @SerializedName("success") val success: Boolean,
    @SerializedName("terms") val terms: String,
    @SerializedName("privacy") val privacy: String,
    @SerializedName("currencies") val currencies: JsonObject,
    @SerializedName("quotes") val quotes: JsonObject,
    @SerializedName("source") val source: String
)