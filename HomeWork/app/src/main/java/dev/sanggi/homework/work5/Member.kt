package dev.sanggi.homework.work5

import android.os.Parcel
import android.os.Parcelable
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Member(
    @PrimaryKey
    var idx: Long = 0,
    var id: String = "",
    var password: String = ""
) : RealmObject(), Parcelable {
    constructor(source: Parcel) : this(
        source.readLong(),
        source.readString() ?: "",
        source.readString() ?: ""
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeLong(idx)
        writeString(id)
        writeString(password)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Member> = object : Parcelable.Creator<Member> {
            override fun createFromParcel(source: Parcel): Member = Member(source)
            override fun newArray(size: Int): Array<Member?> = arrayOfNulls(size)
        }
    }
}
