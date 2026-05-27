package com.huawei.android.airsharing.api;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.arb;

/* JADX INFO: loaded from: classes3.dex */
public enum EProjectionMode implements Parcelable {
    MIRROR("MIRROR"),
    MEDIA_RESOURCE("MEDIA_RESOURCE"),
    MIRROR_WITHOUT_AUDIO("MIRROR_WITHOUT_AUDIO");

    private static final String TAG = "EProjectionMode";
    private String projectionMode;
    private static arb sLog = arb.d();
    public static final Parcelable.Creator<EProjectionMode> CREATOR = new Parcelable.Creator<EProjectionMode>() { // from class: com.huawei.android.airsharing.api.EProjectionMode.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: eK_, reason: merged with bridge method [inline-methods] */
        public EProjectionMode createFromParcel(Parcel parcel) {
            try {
                return EProjectionMode.valueOf(parcel.readString());
            } catch (IllegalArgumentException | NullPointerException unused) {
                EProjectionMode.sLog.b(EProjectionMode.TAG, "invalid source");
                return EProjectionMode.MIRROR;
            }
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public EProjectionMode[] newArray(int i) {
            return new EProjectionMode[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    EProjectionMode(String str) {
        this.projectionMode = str;
    }

    public String getProjectionMode() {
        return this.projectionMode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (parcel != null) {
            parcel.writeString(name());
        }
    }

    public boolean isProjectionModeValid() {
        return MIRROR.getProjectionMode().equals(this.projectionMode) || MEDIA_RESOURCE.getProjectionMode().equals(this.projectionMode);
    }
}
