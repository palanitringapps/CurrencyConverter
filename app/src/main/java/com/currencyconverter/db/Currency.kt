package com.currencyconverter.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency")
data class Currency(
    @PrimaryKey @ColumnInfo(name = "code") val currencyCode: String,
    @ColumnInfo(name = "c_name") val CountryName: String,
    @ColumnInfo(name = "c_value") val currencyValue: String
)
