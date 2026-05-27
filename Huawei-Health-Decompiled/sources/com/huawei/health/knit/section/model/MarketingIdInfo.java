package com.huawei.health.knit.section.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes4.dex */
public class MarketingIdInfo implements Parcelable {
    public static final Parcelable.Creator<MarketingIdInfo> CREATOR = new Parcelable.Creator<MarketingIdInfo>() { // from class: com.huawei.health.knit.section.model.MarketingIdInfo.5
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: ajm_, reason: merged with bridge method [inline-methods] */
        public MarketingIdInfo createFromParcel(Parcel parcel) {
            return new MarketingIdInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MarketingIdInfo[] newArray(int i) {
            return new MarketingIdInfo[i];
        }
    };
    private final int mFloatingBoxId;
    private final int mPageId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MarketingIdInfo(d dVar) {
        this.mPageId = dVar.d;
        this.mFloatingBoxId = dVar.f2668a;
    }

    private MarketingIdInfo(Parcel parcel) {
        this.mPageId = parcel.readInt();
        this.mFloatingBoxId = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mPageId);
        parcel.writeInt(this.mFloatingBoxId);
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2668a;
        private int d;

        public d e(int i) {
            this.d = i;
            return this;
        }

        public d d(int i) {
            this.f2668a = i;
            return this;
        }

        public MarketingIdInfo d() {
            return new MarketingIdInfo(this);
        }
    }

    public int getmPageId() {
        return this.mPageId;
    }

    public int getmFloatingBoxId() {
        return this.mFloatingBoxId;
    }
}
