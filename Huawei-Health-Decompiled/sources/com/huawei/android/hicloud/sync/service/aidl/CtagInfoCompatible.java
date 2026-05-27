package com.huawei.android.hicloud.sync.service.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes10.dex */
public class CtagInfoCompatible extends CtagInfo {
    public static final Parcelable.Creator<CtagInfoCompatible> CREATOR = new e();
    private int version;

    static final class e implements Parcelable.Creator<CtagInfoCompatible> {
        e() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CtagInfoCompatible[] newArray(int i) {
            return new CtagInfoCompatible[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: gj_, reason: merged with bridge method [inline-methods] */
        public CtagInfoCompatible createFromParcel(Parcel parcel) {
            return new CtagInfoCompatible(parcel, (e) null);
        }
    }

    /* synthetic */ CtagInfoCompatible(Parcel parcel, e eVar) {
        this(parcel);
    }

    @Override // com.huawei.android.hicloud.sync.service.aidl.CtagInfo
    protected void readFromParcel(Parcel parcel) {
        if (parcel.readInt() >= 101) {
            super.readFromParcel(parcel);
            setSyncToken(parcel.readString());
        }
    }

    @Override // com.huawei.android.hicloud.sync.service.aidl.CtagInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.version);
        if (this.version >= 101) {
            super.writeToParcel(parcel, i);
            parcel.writeString(getSyncToken());
        }
    }

    private CtagInfoCompatible() {
        this.version = -1;
    }

    public CtagInfoCompatible(CtagInfo ctagInfo, int i) {
        super(ctagInfo);
        this.version = i;
    }

    private CtagInfoCompatible(Parcel parcel) {
        this.version = -1;
        readFromParcel(parcel);
    }
}
