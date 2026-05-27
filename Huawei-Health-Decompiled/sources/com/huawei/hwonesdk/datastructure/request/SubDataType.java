package com.huawei.hwonesdk.datastructure.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class SubDataType implements Parcelable {
    public static final Parcelable.Creator<SubDataType> CREATOR = new Parcelable.Creator<SubDataType>() { // from class: com.huawei.hwonesdk.datastructure.request.SubDataType.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: bYx_, reason: merged with bridge method [inline-methods] */
        public SubDataType createFromParcel(Parcel parcel) {
            return new SubDataType(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public SubDataType[] newArray(int i) {
            return new SubDataType[i];
        }
    };

    @SerializedName("id")
    private int mId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SubDataType(int i) {
        this.mId = i;
    }

    protected SubDataType(Parcel parcel) {
        this.mId = parcel.readInt();
    }

    public int getmId() {
        return this.mId;
    }

    public void setmId(int i) {
        this.mId = i;
    }

    public String toString() {
        return "SubDataType{mId=" + this.mId + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mId);
    }
}
