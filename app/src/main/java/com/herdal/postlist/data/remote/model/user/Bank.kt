package com.herdal.postlist.data.remote.model.user

import com.google.gson.annotations.SerializedName

data class Bank(
    @SerializedName("cardExpire")
    val cardExpire: String,
    @SerializedName("cardNumber")
    val cardNumber: String,
    @SerializedName("cardType")
    val cardType: String,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("iban")
    val iban: String
)