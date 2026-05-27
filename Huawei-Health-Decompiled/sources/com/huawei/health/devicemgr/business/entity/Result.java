package com.huawei.health.devicemgr.business.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes4.dex */
public class Result implements Parcelable {
    public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() { // from class: com.huawei.health.devicemgr.business.entity.Result.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: SJ_, reason: merged with bridge method [inline-methods] */
        public Result createFromParcel(Parcel parcel) {
            return new Result(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Result[] newArray(int i) {
            return new Result[i];
        }
    };
    private Integer code;
    private String data;
    private String message;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public Result() {
    }

    public Result(int i, String str, String str2) {
        this.code = Integer.valueOf(i);
        this.message = str;
        this.data = str2;
    }

    public static Result success(String str) {
        return new Result(0, "", str);
    }

    public static Result success(String str, String str2) {
        return new Result(0, str, str2);
    }

    public static Result error(int i, String str) {
        return new Result(i, str, null);
    }

    protected Result(Parcel parcel) {
        this.code = Integer.valueOf(parcel.readInt());
        this.message = parcel.readString();
        this.data = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.code.intValue());
        parcel.writeString(this.message);
        parcel.writeString(this.data);
    }
}
