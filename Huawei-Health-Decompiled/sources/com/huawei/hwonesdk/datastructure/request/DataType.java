package com.huawei.hwonesdk.datastructure.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class DataType implements Parcelable {
    public static final Parcelable.Creator<DataType> CREATOR = new Parcelable.Creator<DataType>() { // from class: com.huawei.hwonesdk.datastructure.request.DataType.3
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: bYw_, reason: merged with bridge method [inline-methods] */
        public DataType createFromParcel(Parcel parcel) {
            return new DataType(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DataType[] newArray(int i) {
            return new DataType[i];
        }
    };

    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DataType(int i, String str) {
        this.mId = i;
        this.mName = str;
    }

    protected DataType(Parcel parcel) {
        this.mId = parcel.readInt();
        this.mName = parcel.readString();
    }

    public int getmId() {
        return this.mId;
    }

    public void setmId(int i) {
        this.mId = i;
    }

    public String getmName() {
        return this.mName;
    }

    public void setmName(String str) {
        this.mName = str;
    }

    public String toString() {
        return "DataType{mId=" + this.mId + ", mName='" + this.mName + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mId);
        parcel.writeString(this.mName);
    }
}
