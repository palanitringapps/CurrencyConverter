package com.currencyconverter.data.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

data class Currencies(

    @SerializedName("AED") @ColumnInfo(name = "AED") val aED: String,
    @SerializedName("AFN") @ColumnInfo(name = "AFN") val aFN: String,
    @SerializedName("ALL") @ColumnInfo(name = "ALL") val aLL: String,
    @SerializedName("AMD") @ColumnInfo(name = "AMD") val aMD: String,
    @SerializedName("ANG") @ColumnInfo(name = "ANG") val aNG: String,
    @SerializedName("AOA") @ColumnInfo(name = "AOA") val aOA: String,
    @SerializedName("ARS") @ColumnInfo(name = "ARS") val aRS: String,
    @SerializedName("AUD") @ColumnInfo(name = "AUD") val aUD: String,
    @SerializedName("AWG") @ColumnInfo(name = "AWG") val aWG: String,
    @SerializedName("AZN") @ColumnInfo(name = "AZN") val aZN: String,
    @SerializedName("BAM") @ColumnInfo(name = "BAM") val bAM: String,
    @SerializedName("BBD") @ColumnInfo(name = "BBD") val bBD: String,
    @SerializedName("BDT") @ColumnInfo(name = "BDT") val bDT: String,
    @SerializedName("BGN") @ColumnInfo(name = "BGN") val bGN: String,
    @SerializedName("BHD") @ColumnInfo(name = "BHD") val bHD: String,
    @SerializedName("BIF") @ColumnInfo(name = "BIF") val bIF: String,
    @SerializedName("BMD") @ColumnInfo(name = "BMD") val bMD: String,
    @SerializedName("BND") @ColumnInfo(name = "BND") val bND: String,
    @SerializedName("BOB") @ColumnInfo(name = "BOB") val bOB: String,
    @SerializedName("BRL") @ColumnInfo(name = "BRL") val bRL: String,
    @SerializedName("BSD") @ColumnInfo(name = "BSD") val bSD: String,
    @SerializedName("BTC") @ColumnInfo(name = "BTC") val bTC: String,
    @SerializedName("BTN") @ColumnInfo(name = "BTN") val bTN: String,
    @SerializedName("BWP") @ColumnInfo(name = "BWP") val bWP: String,
    @SerializedName("BYN") @ColumnInfo(name = "BYN") val bYN: String,
    @SerializedName("BYR") @ColumnInfo(name = "BYR") val bYR: String,
    @SerializedName("BZD") @ColumnInfo(name = "BZD") val bZD: String,
    @SerializedName("CAD") @ColumnInfo(name = "CAD") val cAD: String,
    @SerializedName("CDF") @ColumnInfo(name = "CDF") val cDF: String,
    @SerializedName("CHF") @ColumnInfo(name = "CHF") val cHF: String,
    @SerializedName("CLF") @ColumnInfo(name = "CLF") val cLF: String,
    @SerializedName("CLP") @ColumnInfo(name = "CLP") val cLP: String,
    @SerializedName("CNY") @ColumnInfo(name = "CNY") val cNY: String,
    @SerializedName("COP") @ColumnInfo(name = "COP") val cOP: String,
    @SerializedName("CRC") @ColumnInfo(name = "CRC") val cRC: String,
    @SerializedName("CUC") @ColumnInfo(name = "CUC") val cUC: String,
    @SerializedName("CUP") @ColumnInfo(name = "CUP") val cUP: String,
    @SerializedName("CVE") @ColumnInfo(name = "CVE") val cVE: String,
    @SerializedName("CZK") @ColumnInfo(name = "CZK") val cZK: String,
    @SerializedName("DJF") @ColumnInfo(name = "DJF") val dJF: String,
    @SerializedName("DKK") @ColumnInfo(name = "DKK") val dKK: String,
    @SerializedName("DOP") @ColumnInfo(name = "DOP") val dOP: String,
    @SerializedName("DZD") @ColumnInfo(name = "DZD") val dZD: String,
    @SerializedName("EGP") @ColumnInfo(name = "EGP") val eGP: String,
    @SerializedName("ERN") @ColumnInfo(name = "ERN") val eRN: String,
    @SerializedName("ETB") @ColumnInfo(name = "ETB") val eTB: String,
    @SerializedName("EUR") @ColumnInfo(name = "EUR") val eUR: String,
    @SerializedName("FJD") @ColumnInfo(name = "FJD") val fJD: String,
    @SerializedName("FKP") @ColumnInfo(name = "FKP") val fKP: String,
    @SerializedName("GBP") @ColumnInfo(name = "GBP") val gBP: String,
    @SerializedName("GEL") @ColumnInfo(name = "GEL") val gEL: String,
    @SerializedName("GGP") @ColumnInfo(name = "GGP") val gGP: String,
    @SerializedName("GHS") @ColumnInfo(name = "GHS") val gHS: String,
    @SerializedName("GIP") @ColumnInfo(name = "GIP") val gIP: String,
    @SerializedName("GMD") @ColumnInfo(name = "GMD") val gMD: String,
    @SerializedName("GNF") @ColumnInfo(name = "GNF") val gNF: String,
    @SerializedName("GTQ") @ColumnInfo(name = "GTQ") val gTQ: String,
    @SerializedName("GYD") @ColumnInfo(name = "GYD") val gYD: String,
    @SerializedName("HKD") @ColumnInfo(name = "HKD") val hKD: String,
    @SerializedName("HNL") @ColumnInfo(name = "HNL") val hNL: String,
    @SerializedName("HRK") @ColumnInfo(name = "HRK") val hRK: String,
    @SerializedName("HTG") @ColumnInfo(name = "HTG") val hTG: String,
    @SerializedName("HUF") @ColumnInfo(name = "HUF") val hUF: String,
    @SerializedName("IDR") @ColumnInfo(name = "IDR") val iDR: String,
    @SerializedName("ILS") @ColumnInfo(name = "ILS") val iLS: String,
    @SerializedName("IMP") @ColumnInfo(name = "IMP") val iMP: String,
    @SerializedName("INR") @ColumnInfo(name = "INR") val iNR: String,
    @SerializedName("IQD") @ColumnInfo(name = "IQD") val iQD: String,
    @SerializedName("IRR") val iRR: String,
    @SerializedName("ISK") val iSK: String,
    @SerializedName("JEP") val jEP: String,
    @SerializedName("JMD") val jMD: String,
    @SerializedName("JOD") val jOD: String,
    @SerializedName("JPY") val jPY: String,
    @SerializedName("KES") val kES: String,
    @SerializedName("KGS") val kGS: String,
    @SerializedName("KHR") val kHR: String,
    @SerializedName("KMF") val kMF: String,
    @SerializedName("KPW") val kPW: String,
    @SerializedName("KRW") val kRW: String,
    @SerializedName("KWD") val kWD: String,
    @SerializedName("KYD") val kYD: String,
    @SerializedName("KZT") val kZT: String,
    @SerializedName("LAK") val lAK: String,
    @SerializedName("LBP") val lBP: String,
    @SerializedName("LKR") val lKR: String,
    @SerializedName("LRD") val lRD: String,
    @SerializedName("LSL") val lSL: String,
    @SerializedName("LTL") val lTL: String,
    @SerializedName("LVL") val lVL: String,
    @SerializedName("LYD") val lYD: String,
    @SerializedName("MAD") val mAD: String,
    @SerializedName("MDL") val mDL: String,
    @SerializedName("MGA") val mGA: String,
    @SerializedName("MKD") val mKD: String,
    @SerializedName("MMK") val mMK: String,
    @SerializedName("MNT") val mNT: String,
    @SerializedName("MOP") val mOP: String,
    @SerializedName("MRO") val mRO: String,
    @SerializedName("MUR") val mUR: String,
    @SerializedName("MVR") val mVR: String,
    @SerializedName("MWK") val mWK: String,
    @SerializedName("MXN") val mXN: String,
    @SerializedName("MYR") val mYR: String,
    @SerializedName("MZN") val mZN: String,
    @SerializedName("NAD") val nAD: String,
    @SerializedName("NGN") val nGN: String,
    @SerializedName("NIO") val nIO: String,
    @SerializedName("NOK") val nOK: String,
    @SerializedName("NPR") val nPR: String,
    @SerializedName("NZD") val nZD: String,
    @SerializedName("OMR") val oMR: String,
    @SerializedName("PAB") val pAB: String,
    @SerializedName("PEN") val pEN: String,
    @SerializedName("PGK") val pGK: String,
    @SerializedName("PHP") val pHP: String,
    @SerializedName("PKR") val pKR: String,
    @SerializedName("PLN") val pLN: String,
    @SerializedName("PYG") val pYG: String,
    @SerializedName("QAR") val qAR: String,
    @SerializedName("RON") val rON: String,
    @SerializedName("RSD") val rSD: String,
    @SerializedName("RUB") val rUB: String,
    @SerializedName("RWF") val rWF: String,
    @SerializedName("SAR") val sAR: String,
    @SerializedName("SBD") val sBD: String,
    @SerializedName("SCR") val sCR: String,
    @SerializedName("SDG") val sDG: String,
    @SerializedName("SEK") val sEK: String,
    @SerializedName("SGD") val sGD: String,
    @SerializedName("SHP") val sHP: String,
    @SerializedName("SLL") val sLL: String,
    @SerializedName("SOS") val sOS: String,
    @SerializedName("SRD") val sRD: String,
    @SerializedName("STD") val sTD: String,
    @SerializedName("SVC") val sVC: String,
    @SerializedName("SYP") val sYP: String,
    @SerializedName("SZL") val sZL: String,
    @SerializedName("THB") val tHB: String,
    @SerializedName("TJS") val tJS: String,
    @SerializedName("TMT") val tMT: String,
    @SerializedName("TND") val tND: String,
    @SerializedName("TOP") val tOP: String,
    @SerializedName("TRY") val tRY: String,
    @SerializedName("TTD") val tTD: String,
    @SerializedName("TWD") val tWD: String,
    @SerializedName("TZS") val tZS: String,
    @SerializedName("UAH") val uAH: String,
    @SerializedName("UGX") val uGX: String,
    @SerializedName("USD") val uSD: String,
    @SerializedName("UYU") val uYU: String,
    @SerializedName("UZS") val uZS: String,
    @SerializedName("VEF") val vEF: String,
    @SerializedName("VND") val vND: String,
    @SerializedName("VUV") val vUV: String,
    @SerializedName("WST") val wST: String,
    @SerializedName("XAF") val xAF: String,
    @SerializedName("XAG") val xAG: String,
    @SerializedName("XAU") val xAU: String,
    @SerializedName("XCD") val xCD: String,
    @SerializedName("XDR") val xDR: String,
    @SerializedName("XOF") val xOF: String,
    @SerializedName("XPF") val xPF: String,
    @SerializedName("YER") val yER: String,
    @SerializedName("ZAR") val zAR: String,
    @SerializedName("ZMK") val zMK: String,
    @SerializedName("ZMW") val zMW: String,
    @SerializedName("ZWL") val zWL: String
)