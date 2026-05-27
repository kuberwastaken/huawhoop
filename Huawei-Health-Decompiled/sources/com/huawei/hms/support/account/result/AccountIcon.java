package com.huawei.hms.support.account.result;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes10.dex */
public class AccountIcon implements Parcelable {
    public static final Parcelable.Creator<AccountIcon> CREATOR = new Parcelable.Creator<AccountIcon>() { // from class: com.huawei.hms.support.account.result.AccountIcon.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AccountIcon createFromParcel(Parcel parcel) {
            return new AccountIcon(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AccountIcon[] newArray(int i) {
            return new AccountIcon[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6131a;
    private Bitmap b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AccountIcon() {
    }

    private AccountIcon(Parcel parcel) {
        this.f6131a = parcel.readString();
        this.b = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
    }

    public AccountIcon(String str, Bitmap bitmap) {
        this.f6131a = str;
        this.b = bitmap;
    }

    public Bitmap getIcon() {
        return this.b;
    }

    public String getDescription() {
        return this.f6131a;
    }

    public void setIcon(Bitmap bitmap) {
        this.b = bitmap;
    }

    public void setDescription(String str) {
        this.f6131a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6131a);
        parcel.writeParcelable(this.b, i);
    }
}
