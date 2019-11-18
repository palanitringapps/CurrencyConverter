package com.currencyconverter.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CurrencyDao {
    @Query("SELECT * from currency ")
    fun getAllTodos(): List<Currency>

    @Insert
    fun insert(currency: List<Currency>)

    @Update
    fun update(currency: List<Currency>)


    @Query("UPDATE currency SET c_value = :value WHERE code = :id ")
    fun update(value: String, id: String)


    @Query("DELETE FROM currency")
    fun deleteAll()

    @Query("SELECT * FROM currency WHERE code = :code")
    fun selectCurrency(code:String?) : Currency


}