package com.example.data_api.dto


import com.google.gson.annotations.SerializedName

data class CurrenciesDto(
    @SerializedName("Cur_Abbreviation")
    val curAbbreviation: String,
    @SerializedName("Cur_Code")
    val curCode: String,
    @SerializedName("Cur_DateEnd")
    val curDateEnd: String,
    @SerializedName("Cur_DateStart")
    val curDateStart: String,
    @SerializedName("Cur_ID")
    val curID: Int,
    @SerializedName("Cur_Name")
    val curName: String,
    @SerializedName("Cur_Name_Bel")
    val curNameBel: String,
    @SerializedName("Cur_Name_BelMulti")
    val curNameBelMulti: String,
    @SerializedName("Cur_Name_Eng")
    val curNameEng: String,
    @SerializedName("Cur_Name_EngMulti")
    val curNameEngMulti: String,
    @SerializedName("Cur_NameMulti")
    val curNameMulti: String,
    @SerializedName("Cur_ParentID")
    val curParentID: Int,
    @SerializedName("Cur_Periodicity")
    val curPeriodicity: Int,
    @SerializedName("Cur_QuotName")
    val curQuotName: String,
    @SerializedName("Cur_QuotName_Bel")
    val curQuotNameBel: String,
    @SerializedName("Cur_QuotName_Eng")
    val curQuotNameEng: String,
    @SerializedName("Cur_Scale")
    val curScale: Int
)