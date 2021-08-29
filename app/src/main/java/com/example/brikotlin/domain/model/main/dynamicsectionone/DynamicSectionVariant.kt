package com.example.brikotlin.domain.model.main.dynamicsectionone

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
data class DynamicSectionVariant(
    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("name")
    @Expose
    var name: String?,

    @SerializedName("image")
    @Expose
    var image: String?,

    @SerializedName("code")
    @Expose
    var code: String?,

    @SerializedName("available_quantity")
    @Expose
    var availableQuantity: Int,

    @SerializedName("original_price")
    @Expose
    var originalPrice: Int,

    @SerializedName("member_price")
    @Expose
    var memberPrice: Int,

    @SerializedName("consumer_price")
    @Expose
    var consumerPrice: Int,

    @SerializedName("points")
    @Expose
    var points: Int,

    @SerializedName("attributes")
    @Expose
    var attributes: List<DynamicSectionVariantAttribute>? = null,

    @SerializedName("tag")
    @Expose
    var tag: Any,

    @SerializedName("slider")
    @Expose
    var slider: Any,

    @SerializedName("add_points")
    @Expose
    var addPoints: Int,
    @SerializedName("low_limit")
    @Expose
    var lowLimit: Int,

    @SerializedName("low_quantity")
    @Expose
    var lowQuantity: Any,

    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        TODO("attributes"),
        TODO("tag"),
        TODO("slider"),
        parcel.readInt(),
        parcel.readInt(),
        TODO("lowQuantity")
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(image)
        parcel.writeString(code)
        parcel.writeInt(availableQuantity)
        parcel.writeInt(originalPrice)
        parcel.writeInt(memberPrice)
        parcel.writeInt(consumerPrice)
        parcel.writeInt(points)
        parcel.writeInt(addPoints)
        parcel.writeInt(lowLimit)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DynamicSectionVariant> {
        override fun createFromParcel(parcel: Parcel): DynamicSectionVariant {
            return DynamicSectionVariant(parcel)
        }

        override fun newArray(size: Int): Array<DynamicSectionVariant?> {
            return arrayOfNulls(size)
        }
    }

}
