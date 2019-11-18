package com.currencyconverter.ui

import com.currencyconverter.data.model.BaseCurrency

interface DataSource {
    interface ResponseCallBack {
        fun onDataLoad(id: Int, response: BaseCurrency?)

        fun onFailure(id: Int, result: String)
    }

    fun getConvertData(access: String?, callBack: ResponseCallBack)

    fun getLiveData(access: String?, callBack: ResponseCallBack)
}