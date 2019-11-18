package com.currencyconverter.ui

import android.app.Application
import android.util.Log
import com.currencyconverter.data.ApiServices
import com.currencyconverter.data.model.BaseCurrency
import com.currencyconverter.db.Currency
import com.currencyconverter.db.CurrencyDatabase
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository(var app: Application,var dataSource: DataSource) {
    fun getCountry(
        access: String?,
        callback: DataSource.ResponseCallBack
    ) {
        dataSource.getConvertData(access,callback)

    }

    fun getCurrentCurrencyRate(access: String?) {
        val currency = ApiServices.service.getCurrencies(access)
        currency.enqueue(object : Callback<BaseCurrency?> {
            override fun onFailure(call: Call<BaseCurrency?>, t: Throwable) {
                Log.i("failed ", "${t.localizedMessage}")
            }

            override fun onResponse(
                call: Call<BaseCurrency?>,
                response: Response<BaseCurrency?>
            ) {
                if (response.isSuccessful) {
                    Log.i("success", "sjgdsj ${response.body()}")
                    val json = response.body()!!.currencies.toString()
                   // insertCountry(splitJson(json))
                }
            }

        })
    }


}