package omstu.com.osh.data.entities

import android.os.Parcel
import android.os.Parcelable

class ResultTest(
    val current: Int = 0,
    val wrong: Int = 0
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(current)
        parcel.writeInt(wrong)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ResultTest> {
        override fun createFromParcel(parcel: Parcel): ResultTest {
            return ResultTest(parcel)
        }

        override fun newArray(size: Int): Array<ResultTest?> {
            return arrayOfNulls(size)
        }
    }
}
