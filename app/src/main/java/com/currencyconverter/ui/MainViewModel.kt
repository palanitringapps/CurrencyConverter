package com.currencyconverter.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.currencyconverter.base.BaseViewModel
import com.currencyconverter.data.model.BaseCurrency
import com.currencyconverter.db.Currency
import com.currencyconverter.db.CurrencyDatabase
import com.currencyconverter.utils.NetworkConnectionUtil
import org.jetbrains.anko.doAsync


class MainViewModel(
    var app: Application, private var repository: MainRepository,
    private var view: MainView
) : BaseViewModel(app), DataSource.ResponseCallBack {

    private var access: String? = null

    override fun onDataLoad(id: Int, response: BaseCurrency?) {
        if (id == 1) {
            val json = response!!.currencies.toString()
            insertCountry(splitCountry(json))
        } else {
            val json = response!!.quotes.toString()
            updateCurrency(splitLiveCurrency(json))
            view.hideProgress()
        }
    }

    override fun onFailure(id: Int, result: String) {
        view.showCommonError(result)
        view.hideProgress()
    }

    private fun validateCurrenty(from: String?, to: String?): Boolean {
        if (from.equals(to)) {
            view.showSameCurrencyError()
        }
        return !from.equals(to)
    }

    private fun validateAmount(amount: String?): Boolean {
        if (amount!!.isEmpty()) {
            view.showCommonError("Amount is invalid")
        }
        return amount.isNotEmpty()
    }

    fun getCountryList(
        access: String?
    ) {
        this.access = access
        getCountry()
        view.showProgress()
        if (NetworkConnectionUtil.isNetworkConnected(getApplication())) {
            repository.getCountry(access, this)

        } else view.showCommonError("Network not available")
    }


    private fun splitCountry(country: String?): ArrayList<Currency> {

        val currency = ArrayList<Currency>()
        val updated = country!!.replace('{', ' ').replace('}', ' ').replace('\"', ' ').trim()
        val parts = updated.split(",")
        for (items in parts) {
            val sub = items.split(":")
            currency.add(Currency(sub.get(0), sub.get(1), ""))
        }
        return currency
    }

    private fun splitLiveCurrency(country: String?): ArrayList<Currency> {

        val currency = ArrayList<Currency>()
        val updated =
            country!!.replace('{', ' ').replace('}', ' ').replace("USD", "").replace('\"', ' ')
                .trim()
        val parts = updated.split(",")
        for (items in parts) {
            val sub = items.split(":")
            currency.add(Currency(sub.get(0), "", sub.get(1)))
        }
        return currency
    }


    private fun insertCountry(currency: ArrayList<Currency>) {
        doAsync {
            val database = CurrencyDatabase.getDatabase(getApplication())
            database.currencyDao().insert(currency)

            getCurrencyLive(access)
            getCountry()
        }
    }


    private fun updateCurrency(liveCurrency: ArrayList<Currency>) {
        val database = CurrencyDatabase.getDatabase(getApplication())
        doAsync {
            for (current in liveCurrency) {
                database.currencyDao().update(current.currencyValue, current.currencyCode)
            }

            database.currencyDao().getAllTodos()
        }
    }

    private fun getCountry() {
        val list = ArrayList<String>()
        doAsync {
            val database = CurrencyDatabase.getDatabase(getApplication())
            for (items in database.currencyDao().getAllTodos()) {
                list.add(items.currencyCode)
            }

            view.showCountry(list)
        }
    }

    fun getCurrencyLive(string: String?) {
        repository.dataSource.getLiveData(string, this)
    }


    class MainModelFactory(
        private val application: Application,
        private val repository: MainRepository,
        private val view: MainView
    ) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(
                Application::class.java, MainRepository::class.java,
                MainView::class.java
            )
                .newInstance(application, repository, view)
        }

    }

    fun getConvertedAmount(from: String?, to: String?, amount: String?) {
        if (validateCurrenty(from, to)) {
            if (validateAmount(amount)) {
                var fromCurrency: String
                var toCurrency: String


                doAsync {
                    val db = CurrencyDatabase.getDatabase(getApplication())
                    fromCurrency = db.currencyDao().selectCurrency(from).currencyValue
                    toCurrency = db.currencyDao().selectCurrency(to).currencyValue

                    if (fromCurrency.isBlank() || toCurrency.isBlank()) {
                        Log.e("data not available", "Data missing")
                    }
                    val fromFloat: Float = fromCurrency.toFloat()
                    val toFloat: Float = toCurrency.toFloat()

                    val converted = amount!!.toInt() * (toFloat / fromFloat)
                    view.showConvertedValue(String.format("%.2f", converted))
                }
            }
        }
    }
}