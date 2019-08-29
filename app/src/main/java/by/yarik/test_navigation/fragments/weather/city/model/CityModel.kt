package by.yarik.test_navigation.fragments.weather.city.model

import android.os.Parcel
import android.os.Parcelable

data class CityModel(
    val id: Long = 0,
    val title: String = ""
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readLong(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeLong(id)
        writeString(title)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<CityModel> = object : Parcelable.Creator<CityModel> {
            override fun createFromParcel(source: Parcel): CityModel = CityModel(source)
            override fun newArray(size: Int): Array<CityModel?> = arrayOfNulls(size)
        }
    }
}