package com.huawei.hms.kit.awareness.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.kit.awareness.status.WifiStatus;

/* JADX INFO: loaded from: classes10.dex */
public class p implements Parcelable, WifiStatus {
    public static final Parcelable.Creator<p> CREATOR = new Parcelable.Creator<p>() { // from class: com.huawei.hms.kit.awareness.b.p.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p[] newArray(int i) {
            return new p[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p createFromParcel(Parcel parcel) {
            return new p(parcel);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5034a;
    private String b;
    private String c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5034a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }

    @Override // com.huawei.hms.kit.awareness.status.WifiStatus
    public int getStatus() {
        return this.f5034a;
    }

    @Override // com.huawei.hms.kit.awareness.status.WifiStatus
    public String getSsid() {
        return this.c;
    }

    @Override // com.huawei.hms.kit.awareness.status.WifiStatus
    public String getBssid() {
        return this.b;
    }

    private p(Parcel parcel) {
        this.f5034a = parcel.readInt();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    public p(int i, String str, String str2) {
        this.f5034a = i;
        this.b = str;
        this.c = str2;
    }

    public p() {
        this.f5034a = -1;
    }
}
