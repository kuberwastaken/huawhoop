package com.huawei.hms.kit.awareness.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.kit.awareness.status.BeaconStatus;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: loaded from: classes10.dex */
public class b implements Parcelable, BeaconStatus.BeaconData {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.huawei.hms.kit.awareness.b.b.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i) {
            return new b[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }
    };
    public static final String d = "";
    private static final int e = 2048;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5019a;
    private final String b;
    private final byte[] c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5019a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c.length);
        parcel.writeByteArray(this.c);
    }

    public int hashCode() {
        return this.f5019a.hashCode() + this.b.hashCode();
    }

    @Override // com.huawei.hms.kit.awareness.status.BeaconStatus.BeaconData
    public String getType() {
        return this.b;
    }

    @Override // com.huawei.hms.kit.awareness.status.BeaconStatus.BeaconData
    public String getNamespace() {
        return this.f5019a;
    }

    @Override // com.huawei.hms.kit.awareness.status.BeaconStatus.BeaconData
    public byte[] getContent() {
        return a() ? new byte[0] : (byte[]) this.c.clone();
    }

    @Override // com.huawei.hms.kit.awareness.status.BeaconStatus.BeaconData
    public String getBeaconId() {
        return !a() ? "" : new String(this.c, StandardCharsets.UTF_8);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.hashCode() != hashCode() || !(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f5019a.equals(bVar.f5019a) && Arrays.equals(this.c, bVar.c) && this.b.equals(bVar.b);
    }

    private boolean a() {
        return this.f5019a.isEmpty() && this.b.isEmpty();
    }

    public b(byte[] bArr) {
        this.f5019a = "";
        this.b = "";
        this.c = Arrays.copyOf(bArr, bArr.length);
    }

    public b(String str, String str2, byte[] bArr) {
        this.f5019a = str;
        this.b = str2;
        this.c = Arrays.copyOf(bArr, bArr.length);
    }

    public b(String str) {
        this.f5019a = "";
        this.b = "";
        this.c = str.getBytes(StandardCharsets.UTF_8);
    }

    private b(Parcel parcel) {
        this.f5019a = parcel.readString();
        this.b = parcel.readString();
        int i = parcel.readInt();
        if (i <= 0 || i > 2048) {
            this.c = new byte[0];
            return;
        }
        byte[] bArr = new byte[i];
        this.c = bArr;
        parcel.readByteArray(bArr);
    }
}
