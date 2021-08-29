package com.example.brikotlin.domain.model.main.maincategory

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MainCategoryDetails(
    @SerializedName("id") @Expose
    @PrimaryKey val id: Int,
    @SerializedName("name")
    @Expose
    val name: String?,
    @SerializedName("image")
    @Expose
    val image: String?,
    @SerializedName("colorCode")
    @Expose
    val colorCode: String?,
    @SerializedName("order")
    @Expose
    val order: Int,
    @SerializedName("children")
    @Expose
    val children: List<MainCategoryDetailsChild>

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        TODO("children")
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(image)
        parcel.writeString(colorCode)
        parcel.writeInt(order)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainCategoryDetails> {
        override fun createFromParcel(parcel: Parcel): MainCategoryDetails {
            return MainCategoryDetails(parcel)
        }

        override fun newArray(size: Int): Array<MainCategoryDetails?> {
            return arrayOfNulls(size)
        }
    }

}