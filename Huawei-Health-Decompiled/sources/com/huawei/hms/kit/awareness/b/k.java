package com.huawei.hms.kit.awareness.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.kit.awareness.status.CapabilityStatus;
import java.util.Arrays;

/* JADX INFO: loaded from: classes10.dex */
public class k implements Parcelable, CapabilityStatus {
    public static final Parcelable.Creator<k> CREATOR = new Parcelable.Creator<k>() { // from class: com.huawei.hms.kit.awareness.b.k.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k[] newArray(int i) {
            return new k[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k createFromParcel(Parcel parcel) {
            return new k(parcel);
        }
    };
    private static final int b = 100;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f5029a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5029a.length);
        parcel.writeIntArray(this.f5029a);
    }

    @Override // com.huawei.hms.kit.awareness.status.CapabilityStatus
    public int[] getCapabilities() {
        int[] iArr = this.f5029a;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public k(int[] iArr) {
        this.f5029a = Arrays.copyOf(iArr, iArr.length);
    }

    private k(Parcel parcel) {
        int i = parcel.readInt();
        if (i <= 0 || i > 100) {
            this.f5029a = new int[0];
            return;
        }
        int[] iArr = new int[i];
        this.f5029a = iArr;
        parcel.readIntArray(iArr);
    }

    public k() {
        this.f5029a = new int[0];
    }
}
