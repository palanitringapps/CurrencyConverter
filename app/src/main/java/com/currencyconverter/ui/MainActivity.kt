package com.currencyconverter.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.currencyconverter.R
import com.currencyconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {


    private var fromCurrency: String? = null
    private var toCurrency: String? = null
    private lateinit var bind: ActivityMainBinding
    private lateinit var progressBar: ProgressDialog
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ArrayAdapter<String>

    override fun showCountry(list: List<String>?) {
        fromCurrency = list!![0]
        toCurrency = list[0]
        adapter.addAll(list.toMutableList())
        adapter.notifyDataSetChanged()
    }

    override fun showCommonError(error: String?) {
        showMessage(error)
    }

    override fun showProgress() {
        progressBar.show()
    }

    override fun hideProgress() {
        progressBar.dismiss()
    }

    override fun showSameCurrencyError() {
        showMessage(getString(R.string.currency_error))
    }

    override fun showConvertedValue(str: String?) {
        bind.toCurrency.setText(str)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main)
        progressBar = ProgressDialog(this)
        progressBar.setTitle("Converting...")
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ArrayList<String>())
        bind.fromDropdown.adapter = adapter
        bind.toDropdown.adapter = adapter

        val repository = MainRepository(application, RemoteDataService())
        val inviteModelFactory = MainViewModel.MainModelFactory(
            application, repository, this
        )
        viewModel =
            ViewModelProviders.of(this, inviteModelFactory).get(MainViewModel::class.java)
        bind.model = viewModel

        viewModel.getCountryList(getString(R.string.api_key))
        viewModel.getCurrencyLive(getString(R.string.api_key))



        bind.convertButton.setOnClickListener {
            viewModel.getConvertedAmount(
                fromCurrency,
                toCurrency,
                bind.fromCurrency.text.toString().trim()
            )
        }

        bind.fromDropdown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //Nothing selected
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                fromCurrency = parent?.getItemAtPosition(position).toString()
            }

        }

        bind.toDropdown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //Nothing selected
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                toCurrency = parent?.getItemAtPosition(position).toString()
            }

        }

    }

    private fun showMessage(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
