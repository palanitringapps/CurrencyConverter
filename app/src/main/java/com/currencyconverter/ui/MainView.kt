package com.currencyconverter.ui

interface MainView {
    fun showProgress()
    fun hideProgress()
    fun showSameCurrencyError()
    fun showCommonError(error: String?)
    fun showConvertedValue(str: String?)
    fun showCountry(list: List<String>?)
}