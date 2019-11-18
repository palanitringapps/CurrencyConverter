package com.currencyconverter.ui

import com.currencyconverter.data.ApiServices
import com.currencyconverter.data.model.BaseCurrency
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataService : DataSource {

    override fun getLiveData(access: String?, callBack: DataSource.ResponseCallBack) {

        val call = ApiServices.service.getCurrencyLive(access)
        call.enqueue(object : Callback<BaseCurrency?> {
            override fun onFailure(call: Call<BaseCurrency?>, t: Throwable) {
                callBack.onFailure(2, t.localizedMessage)
            }

            override fun onResponse(call: Call<BaseCurrency?>, response: Response<BaseCurrency?>) {
                callBack.onDataLoad(2, response.body())
            }
        }

        )
    }


    override fun getConvertData(access: String?, callBack: DataSource.ResponseCallBack) {
        val call = ApiServices.service.getCurrencies(access)
        call.enqueue(object : Callback<BaseCurrency?> {
            override fun onFailure(call: Call<BaseCurrency?>, t: Throwable) {
                callBack.onFailure(1, t.localizedMessage)
            }

            override fun onResponse(call: Call<BaseCurrency?>, response: Response<BaseCurrency?>) {
                callBack.onDataLoad(1, response.body())
            }
        }

        )
    }

}